import java.util.*;

/*알고리즘
- 전체 길이의 -4 전까지는 *로 바꿔주기
- 나머지 4자리는 배열 그대로 출력하기
*/

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        for(int i = 0; i < phone_number.length(); i++){
           if(i < phone_number.length() - 4) {
               answer += "*";
           }
           else {
               answer += phone_number.charAt(i); 
           }
        }
        return answer;
    }
}