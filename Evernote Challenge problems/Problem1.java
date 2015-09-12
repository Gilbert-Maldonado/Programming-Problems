import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner kb = new Scanner(new File("test.txt"));
		int capacity = kb.nextInt();
		kb.nextLine();
		String [] buffer = new String[capacity];
		processInput(kb, buffer);
		kb.close();
	}
	
	// Processes the input and calls the appropriate method.
	public static void processInput(Scanner kb, String [] buffer) {
		String instruction = kb.nextLine();
		int numOfElements = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		// Keep going until a 'Q' is hit
		while(!instruction.equals("Q")) {
			char ch = instruction.charAt(0);
			// Print the list if an 'L' is hit
			if(ch == 'L') {
				printList(buffer, startIndex, numOfElements);
			}
			else {
				// We know at this point that it is an addition or removal of the buffer so we can parse the int
				int n = Integer.parseInt(instruction.substring(2,3));
				
				// Check to see if the enqueue method should be called or not
				if(ch == 'A') {
					endIndex = enqueue(kb, buffer, n, endIndex);
					if((numOfElements + n) >= buffer.length) {
						startIndex = (endIndex + n - 1) % buffer.length;
						numOfElements = buffer.length;
					}
					else {
						numOfElements += n;
					}
					
				}
				else {
					numOfElements -= n;
					startIndex = dequeue(buffer, n, startIndex);
				}
			}
			instruction = kb.nextLine();
		}
	}
	
	/*
	 * Appends the elements to the end of the list and overwrites if it wraps around to
	 * the beginning. (The array is NOT the list)
	 */
	public static int enqueue(Scanner kb, String [] buffer, int n, int endIndex) {
		String word = "";
		int end = endIndex;
		int i = 0;
		while(i < n) {
			word = kb.nextLine();
			if(end == buffer.length) {
				end = 0;
			}
			buffer[end] = word;
			end++;
			i++;
		}
		return end;
	}
	
	 /*
	  * Don't actually have to delete the elements, just move the startIndex.
	  * It's okay to do this with this particular problem. O(1)
	  */
	public static int dequeue(String [] buffer, int n, int startIndex) {
		int start = startIndex;
		start = (start + n) % buffer.length;
		return start;
	}
	
	// Prints the contents of the list whenever the 'L' command is seen.
	public static void printList(String [] buffer, int startIndex, int numOfElements) {
		int index = startIndex;
		for(int i = 0; i < numOfElements; i++) {
			System.out.println(buffer[index]);
			index++;
			if(index == buffer.length) {
				index = 0;
			}
		}
	}

}
