import java.util.*;

/*알고리즘
- 반복문 사용하기
  - num이 짝수이면 2로 나누기
  - num이 홀수이면 num = num * 3 + 1을 실행
  - 반복 횟수를 answer에 카운트
- 반복 횟수가 500번을 넘으면 -1 반환
*/
class Solution {
    public int solution(long num) {
        int answer = 0;

        while (num != 1 && answer < 500) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            answer++;
        }
        
        if (num == 1) {
            return answer;
        } else {
            return -1;
        }
    }
}