import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int[] arr = new int[1000];
		
		int index = 0;
		
		for(int i=1; index < 1000; i++) { // 숫자 증가
			for(int j=0; j<i && index < 1000; j++) { //숫자를 해당 숫자만큼 배열에 넣긴
				arr[index++] = i;
			}
		}
		
		int sum = 0;
		
		for(int i=A-1; i<B; i++) {
			sum += arr[i];
		}
		System.out.println(sum);	
	}
}