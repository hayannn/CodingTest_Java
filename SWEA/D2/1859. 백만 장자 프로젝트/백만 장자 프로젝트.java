import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();


		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 0;
			long sum = 0;
			long diff = 0;
			
			for(int i=N-1; i>=0; i--) {
				if(arr[i] >= max) { // 현재의 가격이 최대값보다 크거나 같을 때만 차익 계산
					max = arr[i];
				} else { // 최대값보다 작을 때 차익 계산
					diff = max - arr[i];
					sum += diff;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}