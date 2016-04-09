import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/counter-game
public class CounterGame {

    static final String LOUISE = "Louise";
    static final String RICHARD = "Richard";

    public static void main(String [] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        playGames(n, kb);
        kb.close();
    }

    // Number of games played
    public static void playGames(int n, Scanner kb) {

        for(int test = 0; test < n; test++) {
            long counter = kb.nextLong();
            String winner = findWinner(counter);
            System.out.println(winner);
        }
    }

    // Each game that is played
    public static String findWinner(long counter) {

        boolean gameFinished = false;
        // Starts out with Richard's turn
        boolean turn = true;
        while(!gameFinished) {

            gameFinished = counter == 1;

            if(!gameFinished) {
                // If N is a power of 2, reduce the counter by half of N
                if(Long.bitCount(counter) == 1) {
                    counter >>>= 1;
                }
                else {
                    // If N is not power of 2, reduce the counter by the
                    // largest power of 2 less than N
                    long allOnes = -1;
                    long mask = Long.numberOfLeadingZeros(counter);
                    allOnes >>>= mask + 1;
                    counter &= allOnes;
                }
                turn = !turn;
            }
            
        }
        return turn ? RICHARD : LOUISE;
    }
}