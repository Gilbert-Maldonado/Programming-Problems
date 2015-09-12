import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TwoButtons {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int tgt = kb.nextInt();
		System.out.print(findMin(n, tgt));
	}
	
	public static int findMin(int n, int tgt) {
		boolean [] visited = new boolean[10001];
		int min = 0;
		List<Node> list = new LinkedList<Node>();
		list.add(new Node(n, 0));
		boolean found = false;
		int count = -1;
		
		while(!found) {
			Node current = list.remove(0);
			visited[(int)current.getValue()] = true;
			count++;
			if((int) current.getValue() == tgt) {
				found = true;
				count++;
				min = (int) current.getDepth();
			}
			
			if(!found) {
				int subCurr = (int)current.getValue() - 1;
				int multCurr = (int) current.getValue() * 2;
				if(subCurr >= 0 && !visited[subCurr]) {
					list.add(new Node(subCurr, (int)current.getDepth() + 1));
				}
				if(multCurr < 10001 && !visited[multCurr]) {
					list.add(new Node(multCurr, (int) current.getDepth() + 1));
				}
			}
		}
		return min;
	}
	
	private static class Node<E> {
		private E value;
		private E depth;
		
		public Node(E value, E depth) {
			this.value = value;
			this.depth = depth;
		}
		
		public E getValue() {
			return value;
		}
		
		public E getDepth() {
			return depth;
		}
	}

}
