import java.util.Scanner;

public class Problem3 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		long [] arr = new long[n];
		createArray(kb, n, arr);
		traverseArr(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		kb.close();
	}
	
	// Creates the array with the data given
	public static void createArray(Scanner kb, int n, long[] arr) {
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
	}
	
	public static void traverseArr(long[] arr) {
		long product = 1;
		long countZeros = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				countZeros++;
			}
			else {
				product *= arr[i];
			}
			
		}
		
		// If there is more than one zero then every index in the array will be zero.
		if(countZeros > 1) {
			product = 0;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(product == 0) {
				arr[i] = 0;
			}
			else if(arr[i] == 0) {
				arr[i] = product;
			}
			else {
				arr[i] = product / arr[i];
			}
		}
	}
}
