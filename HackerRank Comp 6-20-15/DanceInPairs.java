import java.util.Arrays;
import java.util.Scanner;


public class DanceInPairs {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		long numOfPairs = kb.nextLong();
		long absoluteDifference = kb.nextLong();
		long [] boys = new long[(int)numOfPairs];
		long [] girls = new long[(int)numOfPairs];
		createArrays(kb, boys, girls);
		long max = calcMaxNumOfPairs(boys, girls, absoluteDifference);
		System.out.print(max);
	}
	
	private static void createArrays(Scanner kb, long [] boys, long [] girls) {
		
		for(int index = 0; index < boys.length; index++) {
			boys[index] = kb.nextLong();
		}
		Arrays.sort(boys);
		for(int index = 0; index < girls.length; index++) {
			girls[index] = kb.nextLong();
		}
		Arrays.sort(girls);
	}
	
	private static long calcMaxNumOfPairs(long [] boys, long [] girls, long absoluteDifference) {
		long max = 0;
		
		long boysIndex = 0;
		long girlsIndex = 0;
		
		while(boysIndex < boys.length && girlsIndex < girls.length) {
			
			long boyNumber = boys[(int)boysIndex];
			long girlNumber = girls[(int)girlsIndex];
			
			if(Math.abs(boyNumber - girlNumber) <= absoluteDifference) {
				max++;
				boysIndex++;
				girlsIndex++;
			}
			else if(boyNumber < girlNumber) {
				boysIndex++;
			}
			else {
				girlsIndex++;
			}
		}
		return max;
		
	}

}
