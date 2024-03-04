package vt08;
import java.io.*;
import java.util.Arrays;
public class AlumnoMain {

	public static Alumno[] crearAlumnos() {
		Alumno[] listadoAlumnos = {
				new Alumno("Lorenzo", "Garcia", 20, "lorenzogarciagarcia03@gmail.com",new String[] {"NoOlvidoAmiEx","HabraQueSerMongolo"}),
				new Alumno ("JoseCarlos","Florido", 19, "jcmaricona@dueña.com",new String[] {"PalomaMiReina","SoyGayComoMiPrimo"}),
				new Alumno ("Artur", "Kurtaev", 19,"rusitopeludo19@hotmail.es", new String[] {"PaulaNoMePegues","SoyUnMamela"}),
				new Alumno ("Manuel", "Gonzalez", 12, "minoviasiempretienerazon@mamela.com", new String[] {"MeAprietaLaCorrea","NoMeDejanSalir"})
				};
		return listadoAlumnos;
		}
	
	public static void EscribirFicheroBinarioDos(Alumno[] listado) {
		
		try (DataOutputStream f = new DataOutputStream(new FileOutputStream ("alumnos.bin"))) {
			
			for (Alumno alumno:listado) {
				f.writeUTF(alumno.getNombre());
				f.writeUTF(alumno.getApellido());
				f.writeInt(alumno.getEdad());
				f.writeUTF(alumno.getEmail());
				f.writeInt(alumno.getModulos().length);
				for(String modulos : alumno.getModulos()) {
					f.writeUTF(modulos);
				}
			}
			f.close();
		}catch (IOException e) {
			System.out.println("Error al escribir el archivo: " + e.getMessage());
		}
		}
	
	public static void LeerFicheroBinarioDos() throws IOException {
		DataInputStream in = null;
		
		try {
			in = new DataInputStream(new FileInputStream("alumnos.bin"));
			while(true) {
				String nombre = in.readUTF();
				String apellido = in.readUTF();
				int edad = in.readInt();
				String email = in.readUTF();
				int numModulos = in.readInt();
				String[] modulos = new String[numModulos];
				for (int i = 0;i<numModulos;i++) {
					modulos[i] = in.readUTF();
				}
				//Imprimir los datos de cada alumno en la consola
				System.out.printf("%s %s (%d años)%n",nombre,apellido,edad);
				System.out.println("Email: " + email);
				System.out.print("Módulos: ");
				for(String modulos1 : modulos) {
					System.out.print(modulos1 + "; ");
				}
				System.out.println();
				
			}
		}catch (EOFException e) {
			System.out.println("Fin de fichero.");
		}catch(IOException e) {
			System.out.println("Error al leer el archivo.");
		}
		finally {
			in.close();
		}
	}
		public static void EscribirFicheroBinarioRAF(Alumno alumno) {
			try (RandomAccessFile file = new RandomAccessFile("alumnos.bin", "rw")){
				file.seek(file.length());
				file.writeUTF(alumno.getNombre());
				file.writeUTF(alumno.getApellido());
				file.writeInt(alumno.getEdad());
				file.writeUTF(alumno.getEmail());
				file.writeInt(alumno.getModulos().length);
				for(String modulos : alumno.getModulos()) {
					file.writeUTF(modulos);
				}
				file.close();	
			}catch(IOException e) {
				System.out.println("Error al escribir el archivo" + e.getMessage());
			}
		}
		
		public static void LeerFicheroBinarioRAF() {
			try (RandomAccessFile file = new RandomAccessFile("alumnos.bin", "r")){
				while(file.getFilePointer() < file.length()) {
					String nombre = file.readUTF();
					String apellido = file.readUTF();
					int edad = file.readInt();
					String email = file.readUTF();
					int numModulos = file.readInt();
					String[] modulos = new String[numModulos];
					for (int i=0;i<numModulos;i++) {
						modulos[i] = file.readUTF();
					}
					
					//Imprimir los datos de cada alumno por consola
					System.out.printf("%s %s (%d años)%n", nombre,apellido,edad);
					System.out.println("Email: " + email);
					System.out.println("Módulos: ");
					for (String modulo:modulos) {
						System.out.print(modulo + " , ");
					}
					System.out.println();
				}
				file.close();
				}catch(EOFException e) {
					System.out.println("Fin de fichero");
				}catch(IOException e) {
					System.out.println("Error a la hora de leer el fichero.");
				}
			
		}
		
		public static void EscribirFicheroTextoBW(Alumno[] alumnos) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("alumnos.txt"))){
				for (Alumno alumno : alumnos) {
					writer.write(alumno.getNombre()+" ");
					writer.write(alumno.getApellido()+" ");
					writer.write(String.valueOf(alumno.getEdad())+" ");
					writer.write(alumno.getEmail()+" ");
					writer.write(String.valueOf(alumno.getModulos().length)+" ");
					for(String modulo:alumno.getModulos()) {
						writer.write(modulo+",");
					}
					writer.write(".");
					writer.newLine();
				}
				writer.close();
			}catch(IOException e) {
				System.out.println("Error al escribir el archivo: " + e.getMessage());
			}
		}
		
		public static void LeerFicheroTextoBR() {
			try(BufferedReader reader = new BufferedReader(new FileReader("alumnos.txt"))){
				String linea;
				while((linea=reader.readLine()) !=null) {
					String[] datos = linea.split(" ");
					String nombre = datos[0];
					String apellido = datos[1];
					int edad = Integer.parseInt(datos[2]);
					String email = datos[3];
					int numModulos = Integer.parseInt(datos[4]);
					String[] auxModulos = datos[5].split(",");
					String[] modulos = Arrays.copyOf(auxModulos, auxModulos.length-1);
					
					System.out.printf("%s %s (%d años)%n", nombre, apellido, edad);
					System.out.println("Email: " + email);
					System.out.print("Módulos: ");
					for(String modulo:modulos) {
						System.out.print(modulo + ",");
					}
					System.out.println();
				}
				reader.close();
			}catch (EOFException e) {
				System.out.println("Fin de fichero");
			}catch (IOException e) {
				System.out.println("Error a la hora de leer el fichero: " + e.getMessage());
			}
		}
		

	
	public static void main(String[] args) throws IOException {
		
		Alumno[] alumnos = crearAlumnos();
		System.out.println("## ESCRITURA Y LECTURA FICHERO BINARIO DataInputStream y DataOutPutStream ##");
		EscribirFicheroBinarioDos(alumnos);
		System.out.println("Escrito1");
		LeerFicheroBinarioDos();
		System.out.println("FIN");
		System.out.println("## ESCRITURA Y LECTURA FICHERO BINARIO RandomAccesFile ##");
		Alumno nuevoAlumno = new Alumno("Marco", "Domínguez", 18, "megustanlaspollascalentitas@miculoesunbebederodepatos.es",new String[] {"CuantoMasGordasMejor", "LechitapaMiCarita"});
		EscribirFicheroBinarioRAF(nuevoAlumno);
		System.out.println("Escrito 2");
		LeerFicheroBinarioRAF();
		System.out.println("FIN");
		EscribirFicheroTextoBW(alumnos);
		System.out.println("\nEscrito 3: ");
		LeerFicheroTextoBR();
	}

}
