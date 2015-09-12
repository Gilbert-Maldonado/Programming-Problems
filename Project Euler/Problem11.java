import java.io.*;
import java.util.*;

public class Problem11 {
    
    public static void main(String [] args) throws FileNotFoundException
    {
        
        Scanner kb = new Scanner(new File("productGrid.txt"));
        
        int [][] arr = new int[20][20];
        addElements(kb,arr);
        
        int largestProduct = (int) computeLargestProduct(arr);
        System.out.println(largestProduct);
    }
    
    //Adds the elements to the array
    public static void addElements(Scanner kb, int[][] arr)
    {
        for(int row = 0;row < arr.length;row++)
        {
            for(int col = 0;col < arr[row].length;col++)
            {
                arr[row][col] = kb.nextInt();
            }
        }
    }
    
    //Computes the largest product of any 4 numbers lined up in the Grid
    public static int computeLargestProduct(int[][] arr)
    {
        int largestProduct = 1;
        
        for(int row = 0;row < arr.length;row++)
        {
            for(int col = 0;col < arr[row].length;col++)
            {
                int temp = checkLeft(arr,row,col);
                if(temp > largestProduct)
                {
                    largestProduct = temp;
                }
            }
        }
        return largestProduct;
    }
    
    //Finds the grestest product from left to right of the index
    public static int checkLeft(int[][] arr, int row, int col)
    {
        int product = 1;
        
        for(int i = col-3;i <= col+3;i++)
        {
            if(inbounds(row,i) && inbounds(row,i+3))
            {
                int temp = arr[row][i] * arr[row][i+1] * arr[row][i+2]
                                    * arr[row][i+3];
                if(temp > product)
                {
                    product = temp;
                }
            }
        }
        return Math.max(product,checkBottomLeft(arr,row,col));
    }
    
    //Finds the greatest product from bottomleft to topright of the index
    public static int checkBottomLeft(int[][] arr, int row, int col)
    {
        int product = 1;
        int column = col - 3;
        
        for(int i = row+3;i >= row-3;i--)
        {
            if(inbounds(i,column) && inbounds(i-3,column + 3))
            {
                int temp = arr[i][column] * arr[i-1][column+1] * arr[i-2][column+2]
                                        * arr[i-3][column+3];
                if(temp > product)
                {
                    product = temp;
                }
            }
            column++;
        }
        return Math.max(product,checkBottomUp(arr,row,col));
    }
    
    //Finds the greatest product from the bottom to the top of the index
    public static int checkBottomUp(int[][] arr,int row,int col)
    {
        int product = 1;
        
        for(int i = row+3;i >= row-3;i--)
        {
            if(inbounds(i,col) && inbounds(i-3,col))
            {
                int temp = arr[i][col] * arr[i-1][col] * arr[i-2][col] *
                                arr[i-3][col];
                if(temp > product)
                {
                    product = temp;
                }
            }
        }
        return Math.max(product,checkBottomRight(arr,row,col));
    }
    
    //Finds the greatest product from the bottom-right to top-left of the index
    public static int checkBottomRight(int[][] arr, int row, int col)
    {
        int product = 1;
        int column = col+3;
        
        for(int i = row+3;i > row-3;i--)
        {
            if(inbounds(i,column) && inbounds(i-3,column-3))
            {
                int temp = arr[i][column] * arr[i-1][column-1] * arr[i-2][column-2]
                               * arr[i-3][column-3];
                if(temp > product)
                {
                    product = temp;
                }
            }
            column--;
        }
        return product;
    }
    
    public static boolean inbounds(int row, int col)
    {
        return row >= 0 && row <= 19 && col >= 0 && col <= 19;
    }
}