package uf1;

public class Ej12MiClaseJUnit {
	
	public int numero_mayor(int a, int b, int c) {
		
		if(a > b && a > c) {
			return a;
		}else if(c > b) {
			return c;
		}else {
			return b;
		}
	}
}
