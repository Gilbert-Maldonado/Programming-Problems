import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WhiteFalconAndSequence {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner kb = new Scanner(new File("test4.txt"));
		long boxSize = kb.nextLong();
		long [] arr = new long[(int) boxSize];
		calculateArray(kb, arr);
		long answer = findSummation(arr);
		System.out.print(answer);
	}
	
	private static void calculateArray(Scanner kb, long [] arr) {
		
		for(int index = 0; index < arr.length; index++) {
			arr[index] = kb.nextLong();
		}
	}
	
	private static long findSummation(long [] arr) {
		long answer = 0;
		
		for(int index = 2; index <= arr.length / 2; index++) {
			long boxSize = index;
			long temp = findSummationHelper(arr, boxSize);
			if(temp > answer) {
				answer = temp;
			}
		}
		return answer;
	}
	
	private static long findSummationHelper(long [] arr, long boxSize) {
		long sum = 0;
		
		for(int first = 0; first <= arr.length - boxSize * 2; first++) {
			
			for(int second = first + (int) boxSize; second <= arr.length - boxSize; second++) {
				long temp = 0;
				for(int index = 0; index < boxSize; index++) {
					temp += arr[first+index] * arr[second + (int) boxSize - index - 1];
				}
				System.out.print("BoxSize: " + boxSize);
				System.out.print(" First array index: " + first + ".");
				System.out.print(" Second array index: " + second + ".");
				System.out.println(" Answer is " + temp + ".");
				if(temp > sum) {
					sum = temp;
				}
			}
		}
		return sum;
	}

}
