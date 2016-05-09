import java.io.*;
import java.util.*;

// Easy problem on HackerRank
public class JavaStringReverse {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String B = new StringBuilder(A).reverse().toString();
        System.out.println(A.equals(B) ? "Yes" : "No");
    }
}
