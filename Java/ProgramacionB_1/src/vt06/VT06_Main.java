package vt06;
import java.util.Arrays;

public class VT06_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matriz = new int[2][];
		
		matriz[0] = new int[] {4,3,3,2};
		matriz[1] = new int[] {7,4,8,0};
		
		
		for (int i=0; i < 2;i++) {
			System.out.println();
			for (int j=0;j < matriz[i].length;j++) {
				System.out.print(matriz[i][j] + " ");
			}
		}
		
		System.out.println();
		System.out.println(matriz.length);
		System.out.println(matriz.toString());
		System.out.println(Arrays.toString(matriz));
		System.out.println(Arrays.toString(matriz[0]));
		System.out.println(Arrays.toString(matriz[1]));
		System.out.println(Arrays.hashCode(matriz));
	}

}
