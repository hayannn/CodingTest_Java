import java.util.*;

/* 알고리즘
- signs가 true라면 -> 배열의 합하기
- signs가 false라면 -> 배열에서 빼기
*/

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++){
            
            if(signs[i] == true){
                answer += absolutes[i];
            }
            
            else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}