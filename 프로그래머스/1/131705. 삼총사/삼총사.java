import java.util.*;
/* 알고리즘
1. 첫번째 수 비교하기
2. 두번째 수부터 비교하기
3. 세번째 수부터 비교하기
4. 3개 숫자를 더한 값이 == 0이라면 -> answer++
*/
class Solution {
    public int solution(int[] number) {
        
        int answer = 0;
        
        for(int one = 0; one < number.length; one++) {
            for(int two = one + 1; two < number.length; two++) {
                for(int three = two + 1; three < number.length; three++) {
                    if(number[one] + number[two] + number[three] == 0) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}