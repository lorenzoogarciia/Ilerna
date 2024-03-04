package vt06;

public class Matriz3Dimensiones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] matriz3d = new int[3][3][3];
		
		//recorro para rellenar la matriz
		for (int i = 0;i < 3; i++) {
			for (int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					matriz3d[i][j][k] = i+1+j*3;
				}
			}
		}
		
		//recorremos para mostrar la matriz
		for (int i=0;i<3;i++) {
			for (int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					System.out.print(matriz3d[i][j][k] + " ");
				}
			}
		}
		
	}

}
