package Week4;

import java.util.Scanner;

public class Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[]array = new int[num];
		for (int i = 0; i< num; i++) {
			array[i]= scan.nextInt();
		}
		int k = scan.nextInt();
		
		int begin = 0;
		int end = num-1;
		while (true) {
			int mid = (begin+end)/2;
			if (array[mid] > k) {
				end = mid;
				System.out.printf("%d %d\n", mid, array[mid]);
			}else if (array[mid]< k) {
				begin = mid;
				System.out.printf("%d %d\n", mid, array[mid]);
			}else if (array[mid]==k) {
				System.out.printf("%d %d\n", mid, array[mid] );
				break;
			}
			if (begin + 1 >= end ) {
				break;
			}
			
		}
	}

}