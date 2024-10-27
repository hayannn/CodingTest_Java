import java.util.*;

/* 알고리즘
1. wallet, bill 크기를 정렬 -> wallet[0]을 작은 변, wallet[1]을 큰 변으로 설정하기
2. 지폐가 지갑보다 크다면
-> 지폐의 큰 변을 반으로 접기 -> 횟수 계속 증가
*/

class Solution {
    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;

        Arrays.sort(wallet);
        Arrays.sort(bill);

        while (!fit(wallet, bill)) {
            bill[1] /= 2;
            Arrays.sort(bill);
            answer++;
        }
        return answer;
    }

    public static boolean fit(int[] wallet, int[] bill) {
        return (bill[0] <= wallet[0] && bill[1] <= wallet[1]) ||
               (bill[0] <= wallet[1] && bill[1] <= wallet[0]);
    }
}