public class Task2 {
	static int NOD(int a, int b) {
		if(a != b) {
			if(a == 0 || b == 0) {
				return 0;
			}
			if (a % b == 0) {
			    return b;
			}
			if (b % a == 0) {
			    return a;
			}
			if(a < b) {
				return NOD(b, a);
			}
			return NOD(b, a % b);
		}
		else {
			return a;	
		}
	}
public static void main(String[] args) {
		System.out.println(NOD(300, 15));
	}
}
