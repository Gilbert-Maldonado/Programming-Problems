
public class Problem9 {

	public static void main(String[] args) {
		
		int num = 1000;
		
		for(int a = 1;a < num/3;a++){
			for(int b = 1;b < num/2;b++){
				for(int c = 1;c < num/2;c++){
					if((a*a + b*b) == c*c){
						if(a + b + c == num){
							System.out.println(a*b*c);
						}
					}
				}
			}
		}
	}

}
