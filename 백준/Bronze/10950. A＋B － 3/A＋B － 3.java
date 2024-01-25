import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int Arr[] = new int[T];
		
		for(int i=0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			Arr[i] = a + b;
		}
		for(int k : Arr ) {
			System.out.println(k);
		}
	}
}