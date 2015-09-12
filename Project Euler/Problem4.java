import java.util.*;
import java.io.*;

public class Problem4
{
	public static void main(String [] args) throws IOException
	{
		int largest = 0;
		int num = 0;
		for(int i = 1;i<1000;i++)
		{
			for(int j = 1;j<1000;i++)
			{
				num = i * j;
				String numb = Integer.toString(num);
				String reversed_num = new StringBuffer(numb).reverse().toString();
				
				if(numb.equals(reversed_num) && num > largest)
				{
					num = Integer.parseInt(numb);
					largest = num;
				}
			}
		}
	System.out.println("The largest palindrome made from the product of two 3-digit numbers are "
		                + largest + ".");
		
		
	}
	
}