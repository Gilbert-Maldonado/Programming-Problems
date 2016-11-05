import java.util.*;
import java.io.*;

public class WildCardBinaryString {
	public static void main(String[] args) {
		String binaryString = "101?100??";
		printCombinations(binaryString);
	}

	public static void printCombinations(String binaryString) {
		String currentString = "";
		printCombinationsHelper(binaryString, currentString);
	}

	public static void printCombinationsHelper(String binaryString, String currentString) {
		int currentStringLength = currentString.length();
		int binaryStringLength = binaryString.length();
		// Base case: print the resulting string
		if(currentStringLength == binaryStringLength) {
			System.out.println(currentString);
		} else {
			if(binaryString.charAt(currentStringLength) == '?') {
				// Didn't bother using a StringBuffer
				printCombinationsHelper(binaryString, currentString + "0");
				printCombinationsHelper(binaryString, currentString + "1");
			} else {
				currentString = currentString + binaryString.substring(currentStringLength, currentStringLength+1);
				printCombinationsHelper(binaryString, currentString);
			}
		}
	}
}