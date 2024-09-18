import java.util.*;

/*알고리즘
- 놀이기구를 탄 횟수만큼 금액을 추가
    - 자신이 가지고 있는 금액 < 이용료 -> 전체 금액 - 가지고 있는 금액
    - 그렇지 않은 경우 -> 결과는 0
*/

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        long total_amount = 0;

        for(int i=1; i < count+1; i++){
            total_amount += price*i;
        }

        if(money < total_amount) {
            answer = total_amount - money;
        }
        
        else {
            answer = 0;
        }
        return answer;
    }
}