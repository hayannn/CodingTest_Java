import java.util.*;

/*알고리즘
1. score 배열 내림차순 정렬
2. score.length만큼 반복
    - 'score의 전체 길이 - m' -> m개 까지 들어가는 박스 1개를 만드는 방식
    - (i+1) % m == 0 일 경우에만
        - (최저 사과 점수) x (한 상자에 담긴 사과 개수)에 의해 최소값에 m을 곱하여 더한 것이 answer
*/

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        //Arrays.sort(score);
        
        Integer[] scoreBox = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreBox, Collections.reverseOrder());
        
        for(int i=0; i<scoreBox.length; i++){
            if((i+1) % m == 0){
                int minScore = scoreBox[i];
                answer += minScore*m;
            }
        }
        return answer;
    }
}