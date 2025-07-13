import java.util.*;

/* 알고리즘
- `dp[i][j] = i`번째 물건까지 처리 -> B의 흔적 총합이 j인 상황에서 A 흔적 총합의 최솟값 구하기
- A가 훔치는 경우와 B가 훔치는 경우로 나눠 처리
  - A : `dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a)`
  - B : `dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j])`
- 모든 물건 처리 후 -> `dp[size][j]`의 최솟값을 찾아서 n 이상이면 -1 반환, 그렇지 않으면 최솟값 자체를 반환
*/

class Solution {
    static final int INF = 100000;
    
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        int[][] dp = new int[size + 1][m];
        
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][0] = 0;
        
        for (int i = 1; i <= size; i++) {
            int a = info[i-1][0]; // A 흔적
            int b = info[i-1][1]; // B 흔적
            
            for (int j = 0; j < m; j++) {
                // A가 선택
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                
                // B가 선택
                if (j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
                }
            }
        }
        
        int min = INF;
        for (int j = 0; j < m; j++) {
            min = Math.min(dp[size][j], min);
        }
        
        return min >= n ? -1 : min;
    }
}