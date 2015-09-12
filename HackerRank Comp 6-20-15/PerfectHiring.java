import java.util.Scanner;


public class PerfectHiring {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		final long numOfPeople = kb.nextLong();
		long patience = kb.nextLong();
		long lossOfPatience = kb.nextLong();
		long [] arr = calculateArray(kb, numOfPeople);
		long winnerID = calculateWinner(arr, patience, lossOfPatience);
		System.out.print(winnerID);
	}
	
	private static long [] calculateArray(Scanner kb, long numOfPeople) {
		long [] arr = new long[(int) numOfPeople];
		for(int person = 0; person < numOfPeople; person++) {
			arr[person] = kb.nextLong();
		}
		return arr;
	}
	
	private static long calculateWinner(long [] arr, long patience, long lossOfPatience) {
		long winnerID = 1;
		long max = arr[0] * patience;
		long thisPatience = patience - lossOfPatience;
		for(int person = 1; person < arr.length; person++) {
			if(thisPatience * arr[person] > max) {
				winnerID = person + 1;
				max = thisPatience * arr[person];
			}
			thisPatience -= lossOfPatience;
		}
		return winnerID;
	}

}
