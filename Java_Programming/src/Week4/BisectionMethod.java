package Week4;

import java.util.Scanner;

public class BisectionMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		double lowerLimit = 0;
		double upperLimit = k;
		while (Math.abs(upperLimit - lowerLimit) >= Math.pow(10, -6)) {
			double center = lowerLimit + (upperLimit-lowerLimit)/2;
			double candidateK = center * center;
			System.out.printf("%.6f %.6f %.6f %.6f\n", lowerLimit, center, upperLimit, candidateK);
			if (candidateK < k) {
				lowerLimit = center;
			}else if (candidateK > k) {
				upperLimit = center;
			}
		}
	}

}