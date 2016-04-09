import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/counter-game
public class CounterGame {

    static final String LOUISE = "Louise";
    static final String RICHARD = "Richard";

    public static void main(String [] args) throws IOException {
        Scanner kb = new Scanner(new File("test.txt"));
        int n = kb.nextInt();
        kb.nextLine();
        playGames(n, kb);
        kb.close();
    }

    // Number of games played
    public static void playGames(int n, Scanner kb) {

        for(int test = 0; test < n; test++) {
            BigInteger counter = kb.nextLine();
            String winner = findWinner(counter);
            System.out.println(winner);
        }
    }

    // Each game that is played
    public static String findWinner(BigInteger counter) {

        boolean gameFinished = false;
        // Starts out with LOUISE's turn
        boolean turn = true;
        while(!gameFinished) {

            gameFinished = counter == 1;

            if(!gameFinished) {
                // If N is a power of 2, reduce the counter by half of N
                if(BigInteger.bitCount(counter) == 1) {
                    counter >>>= 1;
                }
                else {
                    // If N is not power of 2, reduce the counter by the
                    // largest power of 2 less than N
                    long mask = Long.highestOneBit(counter);
                    mask = ~mask;
                    counter &= mask;
                }
                // If the counter is not 1 then switch turns!
                if(counter != 1) {
                    turn = !turn;
                }
                
            }
            
        }
        return turn ? LOUISE : RICHARD;
    }
}
