package vt_01;

public class hala {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[] = new int[5];
		for(int i = 0; i <=5;i++) {
			try {
				numeros[i] = i;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
