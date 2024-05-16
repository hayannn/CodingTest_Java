import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int count = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 1) continue; //1은 소수에서 제외시키기
			
			int primNum = 0;
			
			for(int j=2; j<arr[i]; j++) {
				if(arr[i] % j == 0) {
					primNum++;
					break;
				}
			}
			if(primNum == 0) count++;
		}
		System.out.println(count);
	}
}