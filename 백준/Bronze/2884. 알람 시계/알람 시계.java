import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(b < 45) {
			a--;
			if(a <0 ) {
				a = 23;
			}
			b = 60-(45-b);
			System.out.println(a + " " + b);
		}
		else {
			System.out.println(a + " " + (b - 45));
		}
	}
    
}