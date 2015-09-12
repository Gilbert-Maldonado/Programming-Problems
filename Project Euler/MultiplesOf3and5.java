import java.util.*;
import java.io.*;

public class MultiplesOf3and5
{
	public static void main(String[] args)
	{
		//Question is worded differently
		System.out.println("Please enter a number to find the sum of the multiples of 3 and 5:");
		Scanner kb = new Scanner(System.in);
		int number = kb.nextInt();
		int sum = 0;
		
		for (int i=0; i < number; i++)
    {
        if (i % 3 == 0)
          sum += i;
        else if (i % 5 == 0)
          sum += i;
    }
		System.out.println("The sum of these multiples are " + sum + ".");
	}
}