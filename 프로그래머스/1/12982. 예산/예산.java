import java.util.*;

/* 알고리즘
- 부서별 신청 금액 배열을 오름차순으로 정렬
- 배열 값을 계속 증가(단, count + d <= budget일 경우에만)
*/

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int count = 0;
        
        Arrays.sort(d);
        
        for(int i=0; i<d.length; i++){
            if(count + d[i] <= budget){
                count += d[i];
                answer++;
            }
        }
        return answer;
    }
}