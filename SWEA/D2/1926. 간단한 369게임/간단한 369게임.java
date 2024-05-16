import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		String[] arr = new String[N+1];
		
		for(int i=1; i<=N; i++) {
			
			arr[i] = String.valueOf(i);
			
			 if (arr[i].contains("3") || arr[i].contains("6") || arr[i].contains("9")) {
				 arr[i]= arr[i].replace("3", "-");
		         arr[i]= arr[i].replace("6", "-");
		         arr[i]= arr[i].replace("9", "-");
		
		         arr[i]= arr[i].replace("0", "");
		         arr[i]= arr[i].replace("1", "");
		         arr[i]= arr[i].replace("2", "");
		         arr[i]= arr[i].replace("4", "");
		         arr[i]= arr[i].replace("5", "");
		         arr[i]= arr[i].replace("7", "");
		         arr[i]= arr[i].replace("8", "");
			 }
			 System.out.print(arr[i] + " ");
		}
	}
}