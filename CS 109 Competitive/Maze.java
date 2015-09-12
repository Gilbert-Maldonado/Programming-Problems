import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Maze {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(new File("text.txt"));
		int row = kb.nextInt();
		int col = kb.nextInt();
		int s = 0;
		int[] k = new int[1];
		k[0] = kb.nextInt();
		kb.nextLine();
		char[][] maze = new char[row][col];
		boolean[][] visited = new boolean[row][col];
		s = createMaze(kb, maze);
		k[0] = s - k[0];
		searchMaze(maze, s, k, visited);
		kb.close();
	}
	
	public static void searchMaze(char[][] maze, int s, int [] k, boolean[][] visited) {
		
		// Find the starting position
		int startRow = 0;
		int startCol = 0;
		
		outerloop:
		for(int row = 0; row < maze.length; row++) {
			for(int col = 0; col < maze[0].length; col++) {
				if(maze[row][col] == '.') {
					startRow = row;
					startCol = col;
					break outerloop;
				}
			}
		}
		mazeHelper(maze, visited, k, startRow, startCol);
		
		for(int row = 0; row < maze.length; row++) {
			for(int col = 0; col < maze[0].length; col++) {
				if(maze[row][col] == '.' && !visited[row][col]) {
					maze[row][col] = 'X';
				}
			}
		}
		printMaze(maze);
	}
	
	public static void mazeHelper(char[][] maze, boolean[][] visited, int[] k, int startRow, int startCol) {
		
		if(isValid(maze, startRow, startCol, maze.length, maze[0].length) && k[0] > 0 && !visited[startRow][startCol]) {
			k[0]--;
			visited[startRow][startCol] = true;
			mazeHelper(maze, visited, k, startRow, startCol - 1);
			mazeHelper(maze, visited, k, startRow - 1, startCol);
			mazeHelper(maze, visited, k, startRow, startCol + 1);
			mazeHelper(maze, visited, k, startRow + 1, startCol);
		}
	}
	
	public static boolean isValid(char[][] maze, int startRow, int startCol, int numRows, int numCols) {
		return startRow >= 0 && startRow < numRows && startCol >= 0 && 
					startCol < numCols && maze[startRow][startCol] == '.';
	}
	
	public static int createMaze(Scanner kb, char[][] maze) {
		int row = 0;
		int s = 0;
		
		while(kb.hasNextLine()) {
			String line = kb.nextLine();
			for(int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				maze[row][i] = ch;
				if(ch == '.') {
					s++;
				}
			}
			row++;
		}
		return s;
	}
	
	public static void printMaze(char [][] maze) {
		for(char [] i : maze) {
			for(char ch : i) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}

}
