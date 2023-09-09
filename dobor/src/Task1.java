import java.util.ArrayList;

public class Task1 {
	static void peresechenie(int[] x, int[] y) {
		int k = x.length;
		int l = y.length;
		ArrayList<Integer> z = new ArrayList<>();
		for(int i = 0; i < k;i++) {
			for(int j = 0; j < l; j++) {
				if(x[i] == y[j]) {
					z.add(x[i]);
					break;
				}
			}
		}
		for(int i: z) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] x = new int[] {1,2,2,3,3,5,5,7,7};
		int[] y = new int[] {1,1,3,3,5,5,6,5,6,7,7,7};
		peresechenie(x,y);
	}
}
