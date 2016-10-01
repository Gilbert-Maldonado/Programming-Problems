import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LevenshteinDistance {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        int i = 0;
        while(i < n) {
            String firstString = kb.nextLine();
            String secondString = kb.nextLine();
            int minEdits = findMinEdits(firstString, secondString);
            System.out.println(minEdits);
            ++i;
        }
    }
    
    public static int findMinEdits(String firstString, String secondString) {
        int[][] dpEdits = new int[firstString.length()+1][secondString.length()+1];
        
        for(int i = 0; i < firstString.length() + 1; ++i) {
            dpEdits[i][0] = i;
        }
        
        for(int i = 0; i < secondString.length() + 1; ++i) {
            dpEdits[0][i] = i;
        }
        
        for(int row = 1; row < dpEdits.length; ++row) {
            for(int col = 1; col < dpEdits[0].length; ++col) {
                if(firstString.charAt(row-1) == secondString.charAt(col-1)) {
                    dpEdits[row][col] = dpEdits[row-1][col-1];
                } else {
                    dpEdits[row][col] = Math.min(Math.min(dpEdits[row][col-1], dpEdits[row-1][col-1]), dpEdits[row-1][col]) + 1;
                }
            }
        }
        return dpEdits[firstString.length()][secondString.length()];
    }
}