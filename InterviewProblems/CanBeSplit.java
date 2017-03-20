import java.util.*;
import java.io.*;

public class CanBeSplit {

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<>();
		dictionary.add("Be");
		dictionary.add("Bed");
		dictionary.add("Bat");
		dictionary.add("Bath");
		dictionary.add("at");
		dictionary.add("An");
		dictionary.add("And");
		dictionary.add("on");
		dictionary.add("Beyond");

		dictionary.add("A");
		dictionary.add("a");
		dictionary.add("Apple");
		dictionary.add("Orange");
		dictionary.add("App");
		dictionary.add("an");
		dictionary.add("Or");
	
		System.out.println(canBeSplit("BedBathAndBeyond", dictionary));
		System.out.println();
		System.out.println(canBeSplit("AppleAndOrange", dictionary));
		System.out.println();
		System.out.println(canBeSplit("AppledOrange", dictionary));
	}

	public static boolean canBeSplit(String word, Set<String> dictionary) {
		if(word.equals("")) {
			return true;
		}
		boolean canSplit = false;

		for(int i = 1; i <= word.length(); ++i) {
			if(dictionary.contains(word.substring(0,i))) {
				canSplit = canBeSplit(word.substring(i), dictionary);
				if(canSplit) {
					return true;
				}
			}
			System.out.println(word);
		}
		return false;
	}
}
