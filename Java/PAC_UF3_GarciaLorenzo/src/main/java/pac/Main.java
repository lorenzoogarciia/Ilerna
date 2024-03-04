package pac;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Main {

	@SuppressWarnings("deprecation")
	public static void meterModulos(Session session) {
		Transaction tx = session.beginTransaction();
		Modulo m = new Modulo("Programacion B","M03B");
		session.save(m);
		Modulo m2 = new Modulo("Acceso a datos","M06");
		session.save(m2);
		Modulo m3 = new Modulo("Desarrollo de Interfaces","M07");
		session.save(m3);
		Modulo m4 = new Modulo("Proyecto DAM","M07");
		session.save(m4);
		
		tx.commit();
		List<?> list = session.createQuery("FROM Modulo").list();
		for(Object mod:list) {
			System.out.println(mod.toString());

		}
	}
	
	@SuppressWarnings("deprecation")
	public static void meterProfesor(Session session) {
		Transaction tx = session.beginTransaction();
		Profesor p = new Profesor("Hassabis","Mujer");
		session.save(p);
		
		tx.commit();
		List<?> list = session.createQuery("FROM Profesor").list();
		for(Object prof:list) {
			System.out.println(prof.toString());

		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void meterAlumnos(Session session) {
		Transaction tx = session.beginTransaction();
		
		//Creamos la consulta para obtener los modulos
		List<Modulo> modulos = session.createQuery("FROM Modulo").list();
		
		//Creamos los conjuntos de modulos para cada alumno
		Set<Modulo> modulosAlumno1 = new HashSet<>();
		modulosAlumno1.add(modulos.get(0));
		modulosAlumno1.add(modulos.get(1));
		modulosAlumno1.add(modulos.get(2));
		modulosAlumno1.add(modulos.get(3));
		
		Set<Modulo> modulosAlumno2 = new HashSet<>();
		modulosAlumno2.add(modulos.get(0));
		modulosAlumno2.add(modulos.get(1));
		modulosAlumno2.add(modulos.get(2));
		
		Set<Modulo> modulosAlumno3 = new HashSet<>();
		modulosAlumno3.add(modulos.get(2));
		modulosAlumno3.add(modulos.get(3));
		
		Set<Modulo> modulosAlumno4 = new HashSet<>();
		modulosAlumno4.add(modulos.get(1));
		modulosAlumno4.add(modulos.get(2));
		modulosAlumno4.add(modulos.get(3));
		
		//Creamos los objetos Alumnos
		Alumno a = new Alumno("Sandberg","USA",26,"Mujer",modulosAlumno1);
		Alumno a2 = new Alumno("Fei-Fei Li","China",21,"Mujer",modulosAlumno2);
		Alumno a3 = new Alumno("Sophie Wilson","Reino Unido",19,"Mujer",modulosAlumno3);
		Alumno a4 = new Alumno("Aya Soffer","Israel",35,"Mujer",modulosAlumno4);
		
		session.save(a);
		session.save(a2);
		session.save(a3);
		session.save(a4);
		tx.commit();
		List<Alumno> list = session.createQuery("FROM Alumno").list();
		for(Object al:list) {
			System.out.println(al.toString());
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--INICIO DEL PROGRAMA--");
		
		//Para indicar que queremos usar hibernate definimos las interfaces
		Configuration cfg = new Configuration().configure();
		
		//Unica instancia de SessionFactory en nuestra sesion
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sessionFactory.openSession();
				
		//Insertar datos de los profesores y mostrarlos
		meterProfesor(session);

		//Insertar datos de Modulos y mostrarlos
		meterModulos(session);

		//Insertar datos de los alumnos y mostrarlos
		meterAlumnos(session);

		
		session.close();
		sessionFactory.close();
	}

}
