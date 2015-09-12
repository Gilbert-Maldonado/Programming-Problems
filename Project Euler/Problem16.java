import java.io.*;
import java.util.*;
import java.math.*;

public class Problem16 {
	
	public static void main(String [] args) {
		
		BigInteger sum = new BigInteger("2");
		sum = sum.pow(1000);
		int finalSum = 0;
		String newSum = sum.toString();
		for(int i = 0;i < newSum.length();i++)
		{
			finalSum += Integer.parseInt(newSum.substring(i,i+1));
		}
		System.out.println(finalSum);
	}
}