import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *A Program that finds the maximum total from the top
 *to the bottom of the triangle. There 16384 routes so 
 *a clever algorithm is required.
 */
 
public class Problem18 {
    
    public static void main(String [] args) throws FileNotFoundException {
        
        Scanner kb = new Scanner(new File("p18.txt"));
        int depth = findDepth(kb);
        kb.close();
        kb = new Scanner(new File("p18.txt"));
        int [][] map = new int[depth][0];
        createMap(kb, map);
        kb.close();
        int sum = findLargestSum(map);
        System.out.print(sum);
    }
    
    //Find the number of rows in the text file
    public static int findDepth(Scanner kb) {
        int count = 0;
        while(kb.hasNextLine()) {
            count++;
            kb.nextLine();
        }
        return count;
    }
    
    //Adds the numbers into the jagged 2d array
    public static void createMap(Scanner kb, int[][] map) {
        for(int i = 0;i < map.length;i++) {
            map[i] = new int[i+1];
        }
        for(int i = 0;i < map.length;i++) {
            for(int j = 0;j < map[i].length;j++) {
                map[i][j] = kb.nextInt();
            }
        }
    }
    
    //Finds the path that gives the largest sum
    public static int findLargestSum(int[][] map) {
    	int root = 0;
    	for(int row = map.length - 2; row >= 0; row--) {
    		for(int col = 0; col < map[row].length; col++) {
    			map[row][col] += Math.max(map[row+1][col], map[row+1][col+1]);
    		}
    	}
    	root = map[0][0];
    	return root;
    }
}