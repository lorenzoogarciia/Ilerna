	class A {
		   A() {
		      System.out.println("En A");
		   }
		}
		class B extends A {
		   B() {
		      System.out.println("En B");
		   }
		}
		class C extends B {
		   C() {
		       System.out.println("En C");
		   }
		}
public class Constructores_y_Herencia {
	public static void main(String[] args) {
		C obj = new C();
	}
}
/*
 * 
 *  
 *  */
