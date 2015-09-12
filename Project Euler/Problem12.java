import java.io.*;
import java.util.*;

public class Problem12
{
    public static void main(String[] args) 
    {
        long numOfFactors = 0;
        long n = 0;
        while(numOfFactors < 500)
        {
            n++;
            numOfFactors = countFactors(n*(n+1)/2);
            
        }
        
        System.out.print(n*(n+1)/2);
    }
    
    //Counts the number of factors in the number
    public static long countFactors(long n)
    {
        long total = 1;
        
        for(int i = 1;i <= Math.sqrt(n);i++)
        {
            if(n % i == 0)
            {
                total += 2;
            }
        }
        return total;
    }
}