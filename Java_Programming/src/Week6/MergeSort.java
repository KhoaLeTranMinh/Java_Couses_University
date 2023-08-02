package Week6;
import java.util.*;


public class MergeSort {
	static int num;
	static int[]original = new int[num];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		int arr[] = new int[num];
		for (int i = 0; i< arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		original = Arrays.copyOf(arr, num);
		mergeSort(arr,0,num-1);
		//print(arr);
	}
	public static void print (int arr[]) {
		for (int i = 0; i< arr.length; i++) {
			System.out.printf("%d ",arr[i]);
		}
		System.out.println();
	}
	public static void mergeSort (int arr[], int left, int right) {
		int size = arr.length;
		
		if (size < 2) {
			return;
		}
		int midSize = size/2;
		int[]leftHaft = new int[midSize];
		int[]rightHaft = new int[size - midSize];
		int leftHaft_left = left;
		int leftHaft_right = left+midSize-1;
		int rightHaft_left = left+midSize;
		int rightHaft_right = right;
		for (int i = 0; i < midSize; i++) {
			leftHaft[i] = arr[i];
		}
		for (int j = midSize; j < size; j++) {
			rightHaft[j-midSize] = arr[j];
		}
		mergeSort(leftHaft,leftHaft_left,leftHaft_right);
		mergeSort(rightHaft,rightHaft_left,rightHaft_right);
		merge(arr,leftHaft,rightHaft,left,right);
	}	
	
	public static void merge (int[]arr, int[]leftHaft, int[]rightHaft,int left, int right) {
		int size = arr.length;
		int leftHaftSize = leftHaft.length;
		int rightHaftSize = rightHaft.length;
		int i = 0, j = 0, k = 0;
		while (j<leftHaftSize && k < rightHaftSize) {
			if (leftHaft[j] <= rightHaft[k]) {
				arr[i] = leftHaft[j];
				i++;
				j++;
			}else {
				arr[i] = rightHaft[k];
				i++;
				k++;
			}
		}
		while (j< leftHaftSize) {
			arr[i] = leftHaft[j];
			i++;
			j++;
		}
		while (k <rightHaftSize) {
			arr[i] = rightHaft[k];
			i++;
			k++;
		}
		//For printing
//		System.out.printf("%d %d\n", left,right);
		int[]printOut= Arrays.copyOf(original,num);
		for (int m = left; m<= right; m++) {
			printOut[m] = arr[m-left];
		}
		print(printOut);
		original = printOut;

	}
}
