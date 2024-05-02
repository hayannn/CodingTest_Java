import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.List;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(sc.nextLine());
			List<Integer> numList = Arrays.stream(sc.nextLine().split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
			
			int[] temp = new int[numList.size()];
			int max = 0;
			double result = 0;
			
			for(int i=n-1; i>=0; i--) {
				if(max < numList.get(i).intValue())
					max = numList.get(i).intValue();
					temp[i] = max - numList.get(i).intValue();
			}
            
			for(int i=0; i<temp.length; i++)
				result += temp[i];
			 System.out.println("#" + test_case + " " + Math.round(result));
		}
	}
}