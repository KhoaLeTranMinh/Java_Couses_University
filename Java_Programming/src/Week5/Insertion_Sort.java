package Week5;



import java.util.*;

public class Insertion_Sort {

	public static void swap(int[] a, int i, int j){
		int temp = a[i];
	  	a[i] = a[j];
	  	a[j] = temp;
	}
	public static void print(int[]a, int size) {
		for (int i = 0 ; i < size; i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean hasSwap;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n]; 
		for (int i = 0 ; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		for (int i = 1; i< n; i++) {
			hasSwap = false;
			int key = arr[i];
			int keyNum = i;
			int j = i - 1;
			while (j >= 0 &&  key < arr[j]) {
				hasSwap = true;
				swap(arr,keyNum,j);
				keyNum--;
				j--;
			}
			if(hasSwap) {				
				print(arr,n);
			}
		}
	}

}
