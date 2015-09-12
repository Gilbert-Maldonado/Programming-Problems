import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner kb = new Scanner(new File("test.txt"));
		int n = kb.nextInt();
		kb.nextLine();
		findTerms(kb, n);
		kb.close();
	}
	
	// Finds the k most frequent terms
	public static void findTerms(Scanner kb, int n) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		createMap(map, n, kb);
		int numOfTerms = kb.nextInt();
		String[] terms = new String[numOfTerms];
		ArrayList<FindFrequentTerms> frequentWords = new ArrayList<FindFrequentTerms>();
		for(String key : map.keySet()) {
			frequentWords.add(new FindFrequentTerms(key, map.get(key)));
		}
		Collections.sort(frequentWords);
		printFrequent(frequentWords, numOfTerms > frequentWords.size() ? frequentWords.size() : numOfTerms);
	}
	
	// Creates the map with the word being the key and the number of occurrences being the value
	public static void createMap(Map<String, Integer> map, int n, Scanner kb) {
		for(int i = 0; i < n; i++) {
			String word = kb.nextLine();
			if(map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			}
			else {
				map.put(word, 1);
			}
		}
	}
	
	/*
	 * Nested class to help sort the list first by the number of occurrences and then 
	 * by the word in lexicographical order
	 */
	private static class FindFrequentTerms implements Comparable<FindFrequentTerms> {
		
		String word;
		int occurrences;
		
		public FindFrequentTerms(String word, int occurrences) {
			this.word = word;
			this.occurrences = occurrences;
		}
		
		public int compareTo(FindFrequentTerms other) {
			if(this.occurrences == other.occurrences) {
				return this.word.compareTo(other.word);
			}
			return other.occurrences - this.occurrences;
		}
		
		public String toString() {
			return this.word;
		}
	}
	
	// Prints the k most frequent terms in descending order
	public static void printFrequent(ArrayList<FindFrequentTerms> frequentWords, int numOfTerms) {
		for(int i = 0;i < numOfTerms; i++) {
			System.out.println(frequentWords.get(i));
		}
	}
}
