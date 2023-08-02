package Week_1;

import java.util.Scanner;
import java.util.Arrays;


public class Binary_Search {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		Scanner scan = new Scanner(System.in);
		int a_num = scan.nextInt();
		int[] a = new int[a_num];
		for(int i = 0; i< a_num; i++) {
			a[i]=scan.nextInt();
		}
		int b_num = scan.nextInt();
		int[] b = new int[b_num];
		for(int i = 0; i< b_num; i++) {
			b[i]=scan.nextInt();
		}
		Arrays.sort(a);
		for(int i = 0; i< b_num;i++) {
			if(binary_search(a,b[i],a_num) == true) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	public static Boolean binary_search(int[]arr, int num, int arrSize) {
		int begin = 0;
		int end = arrSize-1;
		while (true)
     {
		int mid = (begin+end)/2;
		if (num == arr[mid]) {
			return true;
		}
		if(begin>=end) {
			return false;
		}
		if (num > arr[mid]) {
			begin = mid + 1;
		}
		if (num < arr[mid]) {
			end = mid - 1;
		}
	  }
	}

}
