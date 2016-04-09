import java.io.*;
import java.util.*;

public class CounterGame {

    static final String LOUISE = "Louise";
    static final String RICHARD = "Richard";

    public static void main(String [] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        playGames(n, kb);
        kb.close();
    }

    public static void playGames(int n, Scanner kb) {

        for(int test = 0; test < n; test++) {
            long counter = kb.nextLong();
            String winner = findWinner(counter);
            System.out.println(winner);
        }
    }

    public static String findWinner(long counter) {

        boolean gameFinished = false;
        // Starts out with Richard's turn
        boolean turn = true;
        while(!gameFinished) {

        }
        return turn ? RICHARD : LOUISE;
    }
}