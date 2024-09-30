import java.util.*;

/* 알고리즘
- a와 b의 값을 곱해서 결과값에 증가시키면 됨.
*/

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i <a.length; i++){
            answer += a[i] * b[i];
        }
        return answer;
    }
}