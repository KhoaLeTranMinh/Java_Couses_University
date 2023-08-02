package Week5;



import java.util.*;

public class Selection_Sort {

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
	
	public static int smallest (int []a, int i, int size ) {
		int smallest = a[i];
		int smallestIndex = i;
		for (int k = i+1; k < size; k++  ) {
			if (a[k] < smallest) {
				smallest = a[k];
				smallestIndex = k;
			}
		}
		return smallestIndex;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int arr[] = new int[size]; 
		for (int i = 0 ; i < size; i++) {
			arr[i] = scan.nextInt();
		}
		for (int i = 0 ; i < size - 1; i++) {
			int smallestIdx = smallest(arr,i,size);
			if (smallestIdx != i) {
				swap(arr,smallestIdx, i);
				print(arr,size);				
			}
		}
	}

}
