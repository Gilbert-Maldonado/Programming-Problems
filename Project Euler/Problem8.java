import java.io.*;
import java.util.*;

public class Problem8 {

    public static void main(String[] args) throws IOException
    {
        
        Scanner kb = new Scanner(new File("numbers.txt"));
        
        String numbers = kb.next();
        
        System.out.println(largestAdjacentProduct(numbers));
    }
    
    public static long largestAdjacentProduct(String numbers)
    {
        long max = 0;
        
        for(int i = 0;i < numbers.length()-13;i++)
        {
            long total = 1;
            String currentNum = numbers.substring(i,i+13);
            for(int j = 0;j<13;j++)
            {
                total = total * Long.parseLong(currentNum.substring(j,j+1));
            }
            if(total > max)
            {
                max = total;
            }
            
        }
        return max;
    }
}