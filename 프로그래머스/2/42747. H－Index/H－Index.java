import java.util.*;

/* 알고리즘
- h : 논문을 기준으로 인용 횟수가 크거나 같은 논문 개수
  - citations[i]가 h보다 크거나 같은 h값을 출력(최초값이 최대값)
*/

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}