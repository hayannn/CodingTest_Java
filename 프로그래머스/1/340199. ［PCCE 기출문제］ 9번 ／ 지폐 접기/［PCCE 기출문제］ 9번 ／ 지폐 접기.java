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

        while (!checkSize(wallet, bill)) {
            fold(wallet, bill);
            answer++;
        }
        return answer;
    }

    private static void fold(int[] wallet, int[] bill) {
       if (bill[0] > bill[1]) {
            bill[0] /= 2;
        } else {
            bill[1] /= 2;
        } 
    }
    private static boolean checkSize(int[] wallet, int[] bill) {
        Arrays.sort(wallet);
        Arrays.sort(bill);

        return bill[0] <= wallet[0] && bill[1] <= wallet[1];
    }
}
