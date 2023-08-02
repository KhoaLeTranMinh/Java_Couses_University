package Week10;

import java.util.Scanner;

public class Ex1_2 {

    public static int gcd(int x, int y) {
        if (y == 0)
            return x;

        return gcd(y, x % y);
    }

    public static int gcdArray(int[] arr, int start, int num) {
        if (num == 1) {
            return arr[start];
        } else if (num == 2) {
            return gcd(arr[start], arr[start + 1]);
        } else {
            return gcd(arr[start], gcdArray(arr, start + 1, num - 1));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many integers: ");
        int num = scan.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = scan.nextInt();
        }
        System.out.println("GCD is: " + gcdArray(arr, 0, num));
    }

}
