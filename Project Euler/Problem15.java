import java.io.*;
import java.util.*;

public class Problem15 {
	
	public static void main(String [] args) {
		long row = 0;
		long col = 0;
		System.out.println(recur(row,col));
	}
	
	
	public static long recur(long row, long col) {
		
	    if(row == 20 || col == 20) {
			return 1;
		}
		else {
			return recur(row+1,col) + recur(row,col+1);
		}
	}
}