import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/stepping-stones-game
public class SteppingStonesGame {

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		int tests = kb.nextInt();
		for(int i = 0; i < tests; i++) {
			playGame(kb);
		}
	}

	public static void playGame(Scanner kb) {
		long desiredLocation = kb.nextInt();
		// n(n + 1) / 2 = sum
		desiredLocation *= 2;
		// sum = n^2 + n
		

	}
}
