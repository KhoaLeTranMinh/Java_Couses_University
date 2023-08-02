package Week10;

import java.util.Scanner;

public class Ex1_1 {
    public static int gcd(int x, int y) {
        if (y == 0)
            return x;

        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("GCD of two integers");
        System.out.print("Input Integer：");
        int x = stdIn.nextInt();
        System.out.print("Input Integer：");
        int y = stdIn.nextInt();
        System.out.println("GCD :" + gcd(x, y));
    }

}
