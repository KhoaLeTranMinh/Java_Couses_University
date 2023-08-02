package Week4;

import java.util.Scanner;

public class TernarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		double lowerLimit = 0;
		double upperLimit = Math.pow(10, 9);
		while (Math.abs(upperLimit - lowerLimit) >= Math.pow(10, -6)) {
			double x1 = lowerLimit + (upperLimit - lowerLimit) / 3;
			double x2 = upperLimit - (upperLimit - lowerLimit) / 3;
			double y1 = A * Math.pow(x1, 2) + B * x1;
			double y2 = A * Math.pow(x2, 2) + B * x2;
			System.out.printf("%.6f %.6f %.6f %.6f %.6f %.6f\n", lowerLimit, x1,x2, upperLimit,y1,y2);
			if (y1 > y2) {
				upperLimit = x2;
			} else if (y2 > y1) {
				lowerLimit = x1;
			}
		}
	}

}