/*
 * Instead of brute forcing our way to find the answer, we 
 * can use DP
 */
public class Problem15 {

	public static void main(String[] args) {
		
		final int rows = 20;
		final int cols = 20;
		// Has to be 21 rows/cols because we are looking at the grid points
		long [][] arr = new long[rows+1][cols+1];
		createArr(arr);
		findPaths(arr);
		// The amount of paths will be at 0, 0
		System.out.println(arr[0][0]);
	}
	
	// Work our way backwards until we get to the top-left
	public static void findPaths(long arr[][]) {
		for(int row = arr.length - 2;row >= 0;row--) {
			for(int col = arr[0].length - 2;col >= 0; col--) {
				arr[row][col] = arr[row+1][col] + arr[row][col+1];
			}
		}
	}
	
	// Create the array with ones on the bottom and right side
	// since there is only one possible path to go from.
	public static void createArr(long[][] arr) {
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[0].length; col++) {
				arr[arr.length-1][col] = 1;
			}
			arr[row][arr[0].length-1] = 1;
		}
	}

}
