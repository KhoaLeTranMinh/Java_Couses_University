package Week7;

import java.util.*;

public class Rotation {
	static int dim;
	static char[][] image;
	static char[][] result;

	public static void print(char[][] arr) {
		System.out.println();
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				System.out.printf("%c", arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void transpose(char[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = row; col < arr[row].length; col++) {
				// checks if i is not equal to j because in transpose matrix diagonal elements
				// will not swap
				if (row != col) {
					// swapping elements
					char temp = arr[row][col];
					arr[row][col] = arr[col][row];
					arr[col][row] = temp;
				}
			}
		}
	}

	public static void reverseEachRow(char arr[][]) {
		for (int row = 0; row < dim; row++) {
			for (int col = 0; col < dim / 2; col++) {
					char temp = arr[row][col];
					arr[row][col] = arr[row][dim - 1 - col];
					arr[row][dim - 1 - col] = temp;
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		dim = scan.nextInt();
	    image = new char[dim][dim];
		result= new char[dim][dim];
		for (int i = 0; i < dim; i++) {
			char[] line = scan.next().toCharArray();
			for (int j = 0; j < dim; j++) {
				image[i][j] = line[j];
			}
		}
		result = image;
		
		print(result);
		rotate(result);
	}

	public static void rotate(char[][]arr) {
		transpose(arr);
		reverseEachRow(arr);
	}

}
