import java.util.*;
import java.io.*;

public class Problem6
{
	public static Integer SumOfSquares(int a)
	{
		int sum = 0;
		for(int i = 1;i<=100;i++)
		{
			sum += i*i;
		}
		return sum;
	}
	public static Integer SquareOfSums(int b)
	{
		int sum = 0;
		for(int j = 1;j<=100;j++)
		{
			sum += j;
		}
		return sum*sum;
	}
	public static void main(String[] args) throws IOException
	{
		int a = SumOfSquares(100);
		int b = SquareOfSums(100);
		int c = b - a;
		System.out.println("The difference between the sum of the squares of the first"
			       + " one hundred natural numbers and the square of the sum is " + c + ".");
	}
}