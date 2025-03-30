/*알고리즘
- 점화식 사용
    - dp[n] = (dp[n-1] + dp[n-2]) % 1234567
*/

class Solution {
    public long solution(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}