import java.io.*;
import java.util.*;
import java.math.*;

// https://www.hackerrank.com/challenges/counter-game
public class CounterGame {

    static final String LOUISE = "Louise";
    static final String RICHARD = "Richard";

    public static void main(String [] args) {
        Scanner kb = new Scanner(System.in);
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

            gameFinished = counter.equals(BigInteger.ONE);

            if(!gameFinished) {
                // If N is a power of 2, reduce the counter by half of N
                if(counter.bitCount() == 1) {
                    counter = counter.divide(new BigInteger("2"));
                }
                else {
                    /* If N is not power of 2, reduce the counter by the
                       largest power of 2 less than N
                       Convert the BigInteger to bitstring */
                    String newBigInt = counter.toString(2);
                    /* If a bit string is '100101', then to reduce it by the 
                    largest power of 2 less than N you simply take off the
                    most significant bit; so it becomes '101' */
                    newBigInt = newBigInt.substring(1);
                    int tempCount = 0;
                    while(newBigInt.charAt(tempCount) == '0') {
                        tempCount++;
                    }
                    newBigInt = newBigInt.substring(tempCount);
                    
                    /* Convert the bit string back to BigInteger, the 
                       second parameter specifies which base the bitstring
                       is in */
                    counter = new BigInteger(newBigInt, 2);
                }
                // If the counter is not 1 then switch turns!
                if(!counter.equals(BigInteger.ONE)) {
                    turn = !turn;
                }
            }
        }
        return turn ? LOUISE : RICHARD;
    }
}
