import java.io.*;
import java.util.*;

// Problem: https://www.hackerrank.com/challenges/two-strings
public class TwoStrings {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        computeStrings(n, kb);
        kb.close();
    }

    public static void computeStrings(int n, Scanner kb) {

        for(int i = 0; i < n; i++) {
            String first = kb.nextLine();
            String second = kb.nextLine();
            
        }
    }
}