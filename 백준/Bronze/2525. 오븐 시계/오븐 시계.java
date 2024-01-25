import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int d = h*60 + m + n;
		h = d/60;
		m = d%60;
		
		if(h >= 24) {
			h = h - 24;
		}
		
		System.out.println(h + " " + m);
	}
}
