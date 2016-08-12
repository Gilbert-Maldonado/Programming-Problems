Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:    

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 

public class Solution {
    public int titleToNumber(String s) {
        int length = s.length();
        int output = 0;
        int pow = 0;
        for(int i = length - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            output += (ch - 64) * (Math.pow(26, pow));
            pow++;
        }
        return output;
    }
}
