package Week7;

import java.util.*;

public class Ultimate {
	static int dim;
	static char[][] image;
	static char[][] result;
	static int[][] imageSign;
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
	public static void rotate(char[][] arr) {
		transpose(arr);
		reverseEachRow(arr);
	}

	public static boolean checkValid(int x, int y) {
		if (x < 0 || y < 0 || x >= dim || y >= dim) {
			return false;
		}
		return true;
	}

	public static void shift( char[][] result, int x, int y) {
		imageSignRenew(result);
		char[][] substitute = new char [dim][dim];
		for (int row = 0; row < dim; row++) {
			for (int col = 0 ; col < dim; col++) {
				if (imageSign[row][col] == 1 ) {
					int newCol = col + x;
					int newRow = row + y;
					if (checkValid(newRow,newCol)) {
						substitute[newRow][newCol] = '#';
					
						if(substitute[row][col] == '#') {
							continue;
						}
						substitute[row][col]='.';
					}else {
						if(substitute[row][col] == '#') {
							continue;
						}else {
							substitute[row][col]='.';
						}
					}
				}else {
					if(substitute[row][col] == '#') {
						continue;
					}
					substitute[row][col]='.';					
				}
			}
		}
		copy2DArray(result, substitute);
	}
	public static void copy2DArray(char[][] result, char[][] substitute) {
		for (int i = 0; i< dim; i++) {
			for (int j = 0; j< dim; j++) {
				result[i][j] = substitute[i][j];
			}
		}
	}
	
	public static void imageSignRenew(char[][] result) {
		for (int i = 0; i < dim; i++) {
			for (int j = 0 ; j < dim; j++) {
				if(result[i][j] == '#') {
					imageSign[i][j] = 1;
				}else {
					imageSign[i][j]= 0;
				}
			}
		}
	}
	public static void dot (char[][] result, int x, int y) {
		result[y][x] = '#';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		dim = scan.nextInt();
		image = new char[dim][dim];
		result = new char[dim][dim];
		imageSign= new int[dim][dim];
		for (int i = 0; i < dim; i++) {
			char[] line = scan.next().toCharArray();
			for (int j = 0; j < dim; j++) {
				image[i][j] = line[j];
			}
		}
		result = image;
		while (true) {
			String com = scan.next();
			switch (com) {
			case "dot":
				int x = scan.nextInt();
				int y = scan.nextInt();
				dot(result,x,y);
				continue;
			case "shift":
				int w = scan.nextInt();
				int z = scan.nextInt();
				shift(result,w,z);
				continue;
			case "rotate":
				rotate(result);
				continue;
			case "end":
				break;
			}
			break;
		}
		print(result);
	}


}