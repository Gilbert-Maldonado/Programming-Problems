import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/coin-change
public class TheCoinChangeProblem {

    public static void main(String [] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] coins = new int[m];
        fillCoinsArr(kb, coins);
        findNumOfWays(n, coins);
        kb.close();
    }

    public static void findNumOfWays(int n, int[] coins) {

    }
    
    public static void fillCoinsArr(Scanner kb, int[] coins) {

        for(int i = 0; i < coins.length; i++) {
            coins[i] = kb.nextInt();
        }
    }
}