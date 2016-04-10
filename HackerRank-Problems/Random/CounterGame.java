import java.io.*;
import java.util.*;
import java.math.*;

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
            BigInteger counter = new BigInteger(kb.nextLine());
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

            gameFinished = counter == BigInteger.ONE;

            if(!gameFinished) {
                // If N is a power of 2, reduce the counter by half of N
                if(counter.bitCount() == 1) {
                    System.out.println("BEFORE: Number: " + counter.toString() + 
                            ", BitCount: " + counter.bitCount());
                    counter = counter.divide(new BigInteger("2"));
                    System.out.println("AFTER: Number: " + counter.toString() + 
                            ", BitCount: " + counter.bitCount());
                }
                else {
                    System.out.println("hi");
                    // If N is not power of 2, reduce the counter by the
                    // largest power of 2 less than N
                    String newBigInt = counter.toString();
                    newBigInt = newBigInt.substring(1);
                    System.out.println(newBigInt);
                    counter = new BigInteger(newBigInt);
                }
                // If the counter is not 1 then switch turns!
                if(counter == BigInteger.ONE) {
                    turn = !turn;
                }
            }
        }
        return turn ? LOUISE : RICHARD;
    }
}
