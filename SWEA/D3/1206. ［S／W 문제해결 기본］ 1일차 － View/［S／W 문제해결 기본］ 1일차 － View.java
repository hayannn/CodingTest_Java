import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int result = 0;
			
			for(int i=2; i<N-2; i++) {
				
				int leftMax = Math.max(arr[i-2], arr[i-1]);
				int rightMax = Math.max(arr[i+1], arr[i+2]);
				
				if(arr[i] > leftMax && arr[i] > rightMax) {
					//result는 현재 건물 높이에서 왼쪽 최댓값과 오른쪽 최댓값 중 큰 값을 뺀 값으로 계산!!
					result += arr[i] - Math.max(leftMax, rightMax);
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}