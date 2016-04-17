import java.io.*;
import java.util.*;

public class Puzzles {

    public static void main(String [] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        List<Integer> list = new ArrayList<Integer>();
        updateList(list, m, kb);
        Collections.sort(list);
        findOutput(list, n);
        kb.close();
    }

    public static void findOutput(List<Integer> list, int n) {
        int smallest = Integer.MAX_VALUE;
        for(int i = 0; i <= list.size() - n; i++) {
            int temp = Math.abs(list.get(i) - list.get(i+n - 1));
            if(temp < smallest) {
                smallest = temp;
            }
        }
        System.out.print(smallest);
    }

    public static void updateList(List<Integer> list, int m, Scanner kb) {
        for(int i = 0; i < m; i++) {
            list.add(kb.nextInt());
        }
    }
}