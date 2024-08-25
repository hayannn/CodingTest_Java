import java.util.*;

/*알고리즘
- 원하는 문자열과 일치하는 경우를 세는 count 선언
- 만약 count가 0이라면 -> x를 i로 반환
- 만약 x와 i가 같다면(두 개의 그룹 글자 수가 같아질때까지) -> count를 증가(그렇지 않을 경우에는 감소시켜야 함)
*/

class Solution {
    public int solution(String s) {
        int answer = 1;
        int count = 1;
        char x = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            if (count == 0) {
                answer++;
                x = s.charAt(i);
            }

            if (x == s.charAt(i)) {
                count++;
            }
            else {
                count--;
            }
        }
        return answer;
    }
}