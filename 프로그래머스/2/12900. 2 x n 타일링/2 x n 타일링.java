/* 알고리즘
- 첫 번째 경우 : 마지막에 2×1 타일 하나를 세로로 배치
  - 2×(n-1) 크기를 채우는 경우의 수
- 두 번째 경우 : 마지막에 1×2 타일 두 개를 가로로 배치
  - 2×(n-2) 크기를 채우는 경우의 수
- 점화식 : dp[n] = dp[n-1] + dp[n-2] 사용
*/

class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        
        return dp[n];
    }
}