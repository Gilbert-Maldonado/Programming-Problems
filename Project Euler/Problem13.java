import java.io.*;
import java.util.*;
import java.math.*;

public class Problem13
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner kb = new Scanner(new File("numbers.txt"));
        
        String sum = computeSum(kb);
        System.out.print(sum);
        
    }
    
    //Computes the sum of the 100 50-digit numbers
    public static String computeSum(Scanner kb)
    {
        int[] sumArray = new int[52];
        
        while(kb.hasNextLine())
        {
            String temp = kb.nextLine();
            addAllNumbers(sumArray,temp);
        }
        System.out.println(Arrays.toString(sumArray));
        String sum = computeFinalSum(sumArray);
        return sum;
    }
    
    public static void addAllNumbers(int[] sumArray, String temp)
    {
        for(int i = temp.length()-1;i >= 0;i--)
        {
            sumArray[i+2] += Integer.parseInt(temp.substring(i,i+1));
        }
    }
    
    public static String computeFinalSum(int[] sumArray)
    {
        String sum = "";
        for(int i = sumArray.length-1; i > 0;i--)
        {
            sumArray[i-1] += sumArray[i]/10;
            sumArray[i] = sumArray[i] % 10;
        }
        
        for(int i = 0;i < sumArray.length;i++)
        {
            sum += sumArray[i];
        }
        System.out.println(Arrays.toString(sumArray));
        return sum;
    }
}