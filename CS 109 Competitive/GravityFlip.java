import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GravityFlip {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int numOfCols = kb.nextInt();
		kb.nextLine();
		ArrayList<Integer> columns = new ArrayList<Integer>();
		createArray(columns, kb, numOfCols);
		Collections.sort(columns);
		printList(columns);
	}
	
	// creates array
	public static void createArray(ArrayList<Integer> columns, Scanner kb, int numOfCols) {
		
		for(int i = 0; i < numOfCols; i++) {
			columns.add(kb.nextInt());
		}
	}
	
	public static void printList(ArrayList<Integer> columns) {
		for(int num : columns) {
			System.out.println(num + " ");
		}
	}
}