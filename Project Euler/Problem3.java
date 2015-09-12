import java.util.*;
import java.io.*;

public class Problem3
{
	public static void main(String[] args) throws IOException
	{//flawed program
		System.out.println("Please enter a number to find the largest prime factor of that number.");
		Scanner kb = new Scanner(System.in);
		long number = kb.nextLong();
		long largestPrime = 0;

		for(long a = 2;a<=number;a++)
		{
			//checks if it's a factor
			if(number%a==0)
			{
		        largestPrime = a;
		        number /= a;
			}
				
		}
		System.out.println("The largest prime factor of the number is " + largestPrime);
	}
}