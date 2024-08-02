import java.util.*;

/* 알고리즘
1. 결과 배열 answer 사용
2. 순위 배열 ranking 선언
3. score 순회
  - ranking이 k보다 크면 가장 낮은 점수 갱신
*/

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> ranking = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            ranking.add(score[i]);
            
            if(ranking.size() > k) {
                ranking.remove(Collections.min(ranking));
            }
            
            answer[i] = Collections.min(ranking);
        }
        return answer;
    }
}