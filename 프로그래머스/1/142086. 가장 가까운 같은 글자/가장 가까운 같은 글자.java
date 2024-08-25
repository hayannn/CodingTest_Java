import java.util.*;

/*알고리즘
- 정답이 될 문자열 길이 설정(s.length)
- 시작점은 -1로 초기화
- 이중 for문
    - 바깥 : 1부터 s.length까지 반복
    - 안쪽 : i-1부터 0까지 감소하며 i와 j가 일치하면 i-j 반환(가장 작은 수를 반환하게 될 것)
*/

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        answer[0] = -1;
        
        for(int i=1; i<s.length(); i++){
            for(int j = i-1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
            answer[i] = i-j;   
                    break;
                } else {
                    answer[i] = -1;
                }
            }
        }
        return answer;
    }
}