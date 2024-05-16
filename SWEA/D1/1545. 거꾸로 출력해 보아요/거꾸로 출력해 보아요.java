import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
			
		Integer[] arr = new Integer[N+1];
			
		for(int i = 0; i<=N; i++) {
		    arr[i] = N - i;
		    System.out.print(arr[i] + " ");
		}
	}
}