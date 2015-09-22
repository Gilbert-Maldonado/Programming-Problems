import java.io.IOException;
import java.util.Scanner;

public class SerialTime {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(System.in);
		int layers = kb.nextInt();
		int rows = kb.nextInt();
		int cols = kb.nextInt();
		kb.nextLine();
		kb.nextLine();
		char [][][] map = new char[rows][cols][layers];
		
		createMap(kb, layers, map);
		int rowStart = kb.nextInt() - 1;
		int colStart = kb.nextInt() - 1;
		int output = findOpenSpots(map, rowStart, colStart);
		System.out.println(output);
	}
	
	public static int findOpenSpots(char [][][] map, int row, int col) {

		int output = openSpotsHelper(map, row, col, 0);
		return output;
	}
	
	public static int openSpotsHelper(char [][][] map, int row, int col, int layer) {
		int sum = 0;
		
		// isValid checks to see if the row and col is in range and if
		// the current spot is an empty spot
		if(isValid(map, row, col, layer)) {
			sum++;
			// X means visited;
			map[row][col][layer] = 'X';
			sum += openSpotsHelper(map, row, col, layer - 1);
			sum += openSpotsHelper(map, row, col - 1, layer);
			sum += openSpotsHelper(map, row - 1, col, layer);
			sum += openSpotsHelper(map, row, col + 1, layer);
			sum += openSpotsHelper(map, row + 1, col, layer);
			sum += openSpotsHelper(map, row, col, layer + 1);
		}
		return sum;
	}
	
	public static boolean isValid(char[][][] map, int row, int col, int layer) {
		return row >= 0 && row < map.length && col >= 0 && col < map[0].length && 
					layer >= 0 && layer < map[0][0].length && map[row][col][layer] == '.';
	}
	// growing from top to bottom, 0 layer is the top!
	public static void createMap(Scanner kb, int layers, char [][][] map) {
		
		int lays = 0;
		
		while(lays < layers) {
			
			for(int row = 0; row < map.length; row++) {
				String line = kb.nextLine();
				for(int col = 0; col < map[0].length; col++) {
					map[row][col][lays] = line.charAt(col);
				}
			}
			kb.nextLine();
			lays++;
		}
	}
	
	public static void printMap(char[][][] map) {
		for(int layer = 0; layer < map[0][0].length; layer++) {
			for(int row = 0; row < map.length; row++) {
				for(int col = 0; col < map[0].length; col++) {
					System.out.print(map[row][col][layer]);
				}
				System.out.println();
			}
		}
		
	}
}
