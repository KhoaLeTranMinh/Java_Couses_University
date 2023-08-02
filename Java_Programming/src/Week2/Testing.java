package Week2;

import java.util.*;

public class Testing {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            long num = scan.nextLong();
            if (num == 0) {
                break;
            }
            int sum = 0;
            while (num != 0) {
                int digit = (int) (num % 10);
                sum += digit;
                num /= 10;
            }
            System.out.println(sum);
        }
    }
}
