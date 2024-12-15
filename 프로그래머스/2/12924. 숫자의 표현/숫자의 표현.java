/* 알고리즘
- 정수 n 입력
- i를 1부터 n까지 반복 -> i부터 n까지의 자연수를 더하는 반복문
- 각 반복에서 합이 n이 되면 -> count 증가, 합 > n이 되면 종료
*/

class Solution {
    public int solution(int n) {
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    count++;
                    break;
                }
                if (sum > n) break;
            }
        }
        
        return count;
    }
}