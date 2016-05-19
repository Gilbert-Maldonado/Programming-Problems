import java.util.*;

// Checks to see if word is the set Dictionary, or the
// subset of words in the dictionary
public class ContainedInDict {

	public static void main(String [] args) {

		Set<String> dict = new HashSet<String>();
		addWordsToSet(dict);
		String word = "BedBathAndBeyond";
		boolean validWord = isWord(word, dict);
		System.out.println(validWord);
	}

	/*
		Recursively backtrack to see if the word or a substring of 
		words is in the dictionary
	*/
	public static boolean isWord(String word, Set<String> dict) {
		
	}

	public static void addWordsToSet(Set<String> dict) {
		dict.add("Be");
		dict.add("Bed");
		dict.add("Bat");
		dict.add("Bath");
		dict.add("And");
		dict.add("An");
		dict.add("Beyond");
		dict.add("on");
	}
}