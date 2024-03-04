import java.util.regex.*;
public class DemoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declara un array de enteros
	    
		String cadena = "a";
		Pattern patron = Pattern.compile("(a||b)+");
		Matcher encaja = patron.matcher(cadena);
		
		//String resultado = encaja.replaceAll("..");
		if(encaja.matches()) {
			System.out.print("SI");
		}else {
			System.out.println("NO");
		}
		
		
		
	}

}
