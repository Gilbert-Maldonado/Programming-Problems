import java.io.IOException;
import java.util.Scanner;

public class Gift {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(System.in);
		StringBuffer word = new StringBuffer();
		word.append(kb.nextLine());
		
		String output = palin(word);
		System.out.print(output);
		kb.close();
	}
	
	public static String palin(StringBuffer word) {
		boolean found = false;
		int index = 0;
		
		while(index <= word.length() && !found) {
			
			int letter = 97;
			while(letter < 123 && !found) {
				word.insert(index, Character.toChars(letter));
				found = isPalin(word);
				if(!found) {
					word.deleteCharAt(index);
				}
				
				letter++;
			}
			index++;
		}
		if(found) {
			return word.toString();
		}
		else {
			return "NA";
		}
	}
	
	// Checks to see if Palindrome
	public static boolean isPalin(StringBuffer word) {
		StringBuffer temp = new StringBuffer(word);
		return temp.toString().equals(temp.reverse().toString());
	}

}
