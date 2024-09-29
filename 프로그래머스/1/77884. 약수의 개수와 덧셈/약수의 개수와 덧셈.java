import java.util.*;

/* 알고리즘
- i = left부터 i <= right까지 반복
- left와 right 사이의 모든 정수 탐색
    - 약수 개수 세기
    - 1부터 i까지의 숫자 j로 나누어지는지 확인
    - i % j == 0일 때 count 증가, 약수 개수 세기
        - count가 짝수면 i를 answer에 더하기
        - count가 홀수면 i를 answer에서 빼기
*/

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int count = 0;
            
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    count++;
                }
            }
            
            if(count % 2 == 0) {
                answer += i;
            }
            else 
            {
                answer -= i;
            }
        }
        
        return answer;
    }
}