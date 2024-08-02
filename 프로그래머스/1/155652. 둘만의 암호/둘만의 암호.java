import java.util.*;

/*알고리즘
1. 문자열 s를 char형으로 변환
2. index를 순회
    - 변환한 문자열 s를 하나씩 증가
    - z를 기준으로 '변환한 문자열 s - 26' 계산
    - skip 조건 추가
3. 정답 문자열에 하나씩 추가
*/

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++){
            char changeS = s.charAt(i);
            
            for(int j=0; j<index; j++){
                changeS++;
                if(changeS > 'z'){
                    //changeS = changeS - 26;
                    changeS -= 26;
                }
                
                //skip
                if(skip.contains(String.valueOf(changeS))){
                    j--;
                }
            }
            answer += changeS;
        }
        return answer;
    }
}