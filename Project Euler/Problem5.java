import java.util.*;
import java.io.*;

public class Problem5
{
	public static void main(String [] args) throws IOException
	{
		boolean isTrue = false;
		int i = 20;
		while(!isTrue)
		{
			int count = 0;
			for(int j = 1;j<=20;j++)
			{
				if(i%j == 0)
				{ count++;	}
			}
			if(count == 20)
			{
			  break;
			}
			i++;
		}
		System.out.println("The smallest positive number that is evenly divisible by " +
			"all of the numbers from 1 to 20 is " + i + ".");
	}
}