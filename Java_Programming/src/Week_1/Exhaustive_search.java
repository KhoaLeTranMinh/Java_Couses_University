package Week_1;

import java.util.Arrays;
import java.util.Scanner;

public class Exhaustive_search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size_a = scan.nextInt();
		int[] sequence = new int[size_a];
		for(int i = 0; i< size_a; i++) {
			sequence[i] = scan.nextInt();
		}
		
		int size_b = scan.nextInt();
		int[] test = new int[size_b];
		for(int i = 0; i< size_b; i++) {
			test[i] = scan.nextInt();
		}
		Arrays.sort(sequence);
		for(int i = 0; i< size_b;i++) {
			if (search(sequence,test[i],0,size_a)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		
	}
	public static boolean search(int arr[], int sum, int i, int arrSize  ) {
		if (sum == 0) {
			return true;
		}
		if (sum < 0 ) {
			return false;
		}
		if(i>= arrSize) {
			return false;
		}
		if(i<arrSize) {
			return  (  
				search(arr, sum, i+1, arrSize) | search(arr,sum-arr[i],i+1,arrSize)
			);
			
		}
		return false;
	}

}
