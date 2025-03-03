import java.util.*;

/* 알고리즘
- n을 k진법으로 변환
- 0을 기준으로 숫자 분리
- 각 숫자에 대한 소수 판별(isPrime)
  - 2 미만 : 소수 아님
  - 2 : 소수
  - 짝수 : 소수 아님
  - 제곱근까지만 나눠서 소수 바로 판별
- 소수가 맞으면 -> count++
*/

class Solution {
    public int solution(int n, int k) {
        String[] arr = Integer.toString(n, k).split("0");
        int count = 0;

        for (String s : arr) {
            if (!s.isEmpty() && isPrime(Long.parseLong(s))) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}