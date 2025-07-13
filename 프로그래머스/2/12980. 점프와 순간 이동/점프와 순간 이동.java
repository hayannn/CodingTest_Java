import java.util.*;

/* 알고리즘
- N -> 0 순서대로 역순 이동하는 방식 활용
- 짝수, 홀수 나눠서 처리(반복)
  - N이 짝수면 -> 2로 나눠서 순간 이동
  - N이 홀수면 -> -1하고 순간 이동(건전지 사용량 +)
*/

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                answer++;
            }
        }
        
        return answer;
    }
}