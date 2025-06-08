import java.util.*;

/* 알고리즘
- nums 리스트에 1부터 n까지 숫자를 넣음
- k번째 순열은 각 자리에서 (k / (n-1)!)번째 숫자부터 시작
- 팩토리얼 배열을 미리 계산해 시간 절약
- 각 자리에 들어갈 숫자를 계산 후 리스트에서 제거
- k--로 0-based index로 조정
*/

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);

        int[] result = new int[n];
        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k--;

        for (int i = 0; i < n; i++) {
            long f = factorial[n - 1 - i];
            int idx = (int) (k / f);
            result[i] = nums.remove(idx);
            k %= f;
        }

        return result;
    }
}