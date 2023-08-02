package Week3;



import java.util.*;

public class ReverseNumSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[]array = new int[n];
		for (int i = 0; i< n; i++) {
			array[i]=scan.nextInt();
		}
		for (int i = n-1; i>= 0; i--) {
			System.out.printf("%d ", array[i]);
		}
	}

}
