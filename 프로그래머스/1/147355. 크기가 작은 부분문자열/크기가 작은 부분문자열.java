import java.util.*;

/*알고리즘
- for문 실행 : 전체 문자열 t를 순회하며 p의 길이만큼 잘라서 비교
    - t의 부분 문자열 tCut 선언(substring으로 자르기)
    - 만약 tCut <= 라면 -> answer 증가
*/

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i=0; i <= t.length() - p.length(); i++){
            
            String tCut = t.substring(i, i+p.length());
            
            if(tCut.compareTo(p) <= 0){
                answer++;
            }
        }
        
        return answer;
    }
}