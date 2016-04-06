import java.io.*;
import java.util.*;

public class AlternatingCharacters {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        computeOutput(n, kb);
        kb.close();
    }

    public static void computeOutput(int n, Scanner kb) {

        for(int i = 0; i < n; i++) {
            String line = kb.nextLine();

            int output = 0;
            for(int index = 1; index < line.length() ; index++) {
                if(line.charAt(index) == line.charAt(index - 1)) {
                    output++;
                }
            }
            System.out.println(output);
        }
    }
}