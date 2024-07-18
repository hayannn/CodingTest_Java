import java.util.*;

/*알고리즘
- 입력
    - 페인트칠 시작점 startP, 페인트칠 끝점 endP, 선언하기
    
- 계산
    - for문으로 조건을 벗어나지 않는 한 반복
        - start <= i <= end를 만족한다면(진행중) -> continue
        - 그렇지 않다면(완료) -> 해당 값을 answer에 증가
    
- 출력
    - answer 반환
*/

class Solution {
    public int solution(int n, int m, int[] section) {
        
        int answer = 0;
        int endP = 0;
        
        for(int i=0; i<section.length; i++){
            if(section[i] > endP){
                endP = section[i] + m - 1;
                answer++;
            }
        }
        return answer;
    }
}