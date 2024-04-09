import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			sc.nextInt();
			int[] score = new int[101]; //100점까지 점수 의 개수 저장
			 
			for(int i=0; i<1000; i++) { //1000명까지 제한
				 score[sc.nextInt()]++;
			 }
			
			 int most=0, result=0; //최빈값과 최빈값인 점수 저장 변수
			 for(int i=0; i < score.length; i++) {
				 if(score[i]>=most) {
					 most = score[i];
					 result = i;
				 }
			 }
			 System.out.println("#" + test_case + " " + result);
		}
	}
}