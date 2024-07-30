import java.util.*;

/*알고리즘
- 추월한 선수에 대한 인덱스 부여하기
- 추월한 선수와 그 앞에 있는 선수를 교체하기
    - callings 길이만큼 반복
*/


class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        
        //List<String> answerArr = Arrays.asList(answer);
        
        Map<String, Integer> answerMap = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            answerMap.put(players[i], i);
        }
        
        for(int i=0; i<callings.length; i++){
            //int rank = answerArr.indexOf(callings[i]);
            int rank = answerMap.get(callings[i]);
            
            String changeName = answer[rank-1];
            
            answer[rank-1] = answer[rank];
            answerMap.put(answer[rank-1], rank-1);
            
            answer[rank] = changeName;
            answerMap.put(answer[rank], rank);
        }
        return answer;
    }
}