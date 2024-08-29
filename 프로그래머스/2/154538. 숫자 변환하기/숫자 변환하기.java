import java.util.*;

/* 알고리즘
- 동적 프로그래밍 이용 : dp[i+연산결과] == 0 || 기존 값 > dp[i] + 1 -> 갱신
  - x에 n을 더하는 경우
    - i+n이 y 이하라면 -> dp[i+n] 반환
  - x에 2를 곱하는 경우
    - i*2가 y 이하라면 -> dp[i*2] 반환
  - x에 3을 곱하는 경우
    - i*3이 y 이하라면 -> dp[i*3] 반환
  - 변환이 안되는 경우 -> -1 반환
*/

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y+1];
        
        for(int i = x; i <= y; i++) {
            // 변환할 수 없는 값이면 -1로 설정
            if(i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            
            // x에 n을 더한 값
            if(i + n <= y) {
                if(dp[i + n] == 0) {
                    dp[i + n] = dp[i] + 1;
                } else {
                    if(dp[i] + 1 < dp[i + n]) {
                        dp[i + n] = dp[i] + 1;
                    }
                }
            }
            
            // x에 2를 곱한 값
            if(i * 2 <= y) {
                if(dp[i * 2] == 0) {
                    dp[i * 2] = dp[i] + 1;
                } else {
                    if(dp[i] + 1 < dp[i * 2]) {
                        dp[i * 2] = dp[i] + 1;
                    }
                }
            }
            
            // x에 3을 곱한 값
            if(i * 3 <= y) {
                if(dp[i * 3] == 0) {
                    dp[i * 3] = dp[i] + 1;
                } else {
                    if(dp[i] + 1 < dp[i * 3]) {
                        dp[i * 3] = dp[i] + 1;
                    }
                }
            }
        }
        return dp[y];
    }
}