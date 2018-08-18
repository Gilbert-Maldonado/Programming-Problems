import java.io.*;
import java.util.*;


public class Problem22 {

	final static int ASCII_VALUE_OF_A = 65;
	
	public static void main(String[] args) throws IOException {
		List<String> listOfNames = new ArrayList<>();
		Scanner kb = new Scanner(new File("names.txt"));
		parseNamesIntoList(kb, listOfNames);
		// Now sort the list of names.
		Collections.sort(listOfNames);
		long score = calculateNameScore(listOfNames);
		System.out.println("Score is:" + score);
		kb.close();
	}

	// Calculate the total sum of the name scores.
	public static long calculateNameScore(List<String> listOfNames) {
		long sum = 0;
		for (int i = 0; i < listOfNames.size(); i++) {

			sum += calculateNameScoreHelper(i+1, listOfNames.get(i));
		}
		return sum;
	}

	// Helper method to calculate the name score.
	public static long calculateNameScoreHelper(int position, String name) {
		long sum = 0;
		for (int index = 0; index < name.length(); index++) {
			char ch = name.charAt(index);
			// Add 1 to start "A" at 1.
			sum += (ch - ASCII_VALUE_OF_A) + 1;
		}
		sum *= position;
		return sum;
	}

	// Puts the file into a list of Strings.
	public static void parseNamesIntoList(Scanner kb, List<String> listOfNames) {
		String line = kb.nextLine();
		String [] names = line.split("[,\"]+");
		// First value is an empty String, so start at 1.
		for (int i = 1; i < names.length; i++) {
			listOfNames.add(names[i]);
		}
	}
}
