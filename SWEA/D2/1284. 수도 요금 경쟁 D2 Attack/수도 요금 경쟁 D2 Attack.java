import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int result = 0;

			for(int i=0; i<W; i++) {
				result = Math.min(W*P, Math.max(Q,Q + (W-R)*S));
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}