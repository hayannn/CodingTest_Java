import java.util.*;

/*알고리즘
- 콜라 개수가 빈 병 a보다 크다면
    - 바꾼 후의 콜라 개수 -> (n/a)*b -> answer에 더하기
    - a의 배수가 아닌 경우(a보다 부족한 경우) -> n%a 더해주기
*/

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            answer += (n/a) * b;
            n = (n/a) * b + (n%a);
        }
        return answer;
    }
}