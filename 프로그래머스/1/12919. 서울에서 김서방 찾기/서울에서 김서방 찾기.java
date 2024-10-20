import java.util.*;

/*알고리즘
- 만약 seoul 배열 안에 "kim"이 있다면 -> answer는 김서방은 i에 있다 출력하기
*/

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
            }
        }        
        return answer;
    }
}