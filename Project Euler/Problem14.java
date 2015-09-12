import java.io.*;
import java.util.*;

public class Problem14 {
	
	public static void main(String [] args) {
		
		long largestCount = 0;
		long largestNumber = 0;
		final long endingNumber = 1000000;
		for(long i = 13;i <= endingNumber;i++)	{
			long count = 1;
			long j = i;
			while(j > 1){
				count++;
				if(j%2 == 0){
					j = j/2;
				}
				else{
					j = (3*j) + 1;
				}
			}
			if(count > largestCount){
				largestNumber = i;
				largestCount = count;
			}
			
		}
		System.out.println(largestNumber);
		System.out.println(largestCount);
		
	}
	
}