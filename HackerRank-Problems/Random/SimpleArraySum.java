import java.io.*;
import java.util.*;

public class SimpleArraySum {

    public static void main(String [] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        printSum(kb, n);
        kb.close();
    }

    public static void printSum(Scanner kb, int n) {

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += kb.nextInt();
        }
        System.out.println(sum);
    }
}
