package Week_1;

import java.util.Scanner;


public class calculatorProgram {

	public static double calculator(double a, char op, double b) {
		double result = 0;
		switch(op) {
		case '+':{
			result = Math.floor(a + b);
			break;
		}
		
		case '-':{
			result = Math.floor(a - b);
			break;
		}
		
		case '*':{
			result = Math.floor(a * b);
			break;
		}
		
		case '/':{
			result = Math.floor(a / b);
			break;
		}
		}
		return result;
		// TODO Auto-generated constructor stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		while (true) {
			double a = scan.nextDouble();
			char op = scan.next().charAt(0);
			double b = scan.nextDouble();
			if (op == '?') {
				break;
			}else {
				System.out.printf("%.0f\n",calculator(a,op,b));
			}
		}
		
	}

}
