import java.util.Scanner;


public class BeginEnd {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		final long LENGTH_OF_STRING = kb.nextLong();
		kb.nextLine();
		String str = kb.nextLine();
		long [] arr = new long[26];
		calculateArray(str, arr, LENGTH_OF_STRING);
		long answer = calcAnswer(arr);
		System.out.print(answer);
	}
	
	private static void calculateArray(String str, long [] arr, long LENGTH_OF_STRING) {
		
		for(int index = 0; index < LENGTH_OF_STRING; index++) {
			char ch = str.charAt(index);
			arr[ch - 97]++; 
		}
	}
	
	private static long calcAnswer(long [] arr) {
		long sum = 0;
		for(int index = 0; index < arr.length; index++) {
			long num = arr[index];
			sum += num;
			sum += num * (num-1) / 2;
		}
		return sum;
	}
}
