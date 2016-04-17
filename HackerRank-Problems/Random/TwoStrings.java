import java.io.*;
import java.util.*;

// Problem: https://www.hackerrank.com/challenges/two-strings
public class TwoStrings {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        computeStrings(n, kb);
        kb.close();
    }

    public static void computeStrings(int n, Scanner kb) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < n; i++) {
            String first = kb.nextLine();
            String second = kb.nextLine();    

            for(int j = 0; j < first.length(); j++) {
                if(map.containsKey(first.charAt(j))) {
                    map.put(first.charAt(j), map.get(first.charAt(j)) + 1);
                } else {
                    map.put(first.charAt(j), 1);
                }
            }   

            boolean found = false;
            int index = 0;
            while(!found && index < second.length()) {
                if(map.get(second.charAt(index)) != null) {
                    found = true;
                }
                index++;
            }
            System.out.println(found ? "YES" : "NO");
            map.clear();
        }

    }
}