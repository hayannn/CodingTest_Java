import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	
	static int[] arr;
	static int N;
	static int max;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
	
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
	
			// 1. 숫자판 정보 arr 및 교환 횟수 N 입력받기
			String num = sc.next();
			arr = new int[num.length()];
            for (int i = 0; i < num.length(); i++) {
                arr[i] = num.charAt(i) - '0';
            }
			
			N = sc.nextInt();
			
			max = 0;
			
			if(arr.length < N) {
            	N = arr.length;
            }
			
			dfs(0,0);
			
			//3. 교환 결과값 출력하기
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	static void dfs(int start, int count){
        if(count == N) {
        	int result = 0;
        	for(int s : arr) {
        		result = result*10 + s;
        	}
        	max = Math.max(max, result);
        	return;
        }
   
        //2. 계산 : 배열 교환 계산하기
		for(int i = start; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                dfs(i, count+1);
                
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;  
			}
		}
    }
}