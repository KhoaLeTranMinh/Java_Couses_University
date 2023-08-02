package Week2;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (true) {
		     int m = scan.nextInt();
		     int f = scan.nextInt();
		     int r = scan.nextInt();
		      if(m + f + r == -3){
		        break;
		      }else if(m == -1 || f == -1){
		        System.out.println("F");
		      }else if(m + f >= 80){
		        System.out.println("A");
		      }else if(m + f >= 65){
		        System.out.println("B");
		      }else if(m + f >= 50){
		        System.out.println("C");
		      }else if(m + f >= 30){
		        if(r >= 50){
		          System.out.println("C");
		        }else{
		          System.out.println("D");
		        }
		      }else{
		        System.out.println("F");
		      }

		}
	}

}
