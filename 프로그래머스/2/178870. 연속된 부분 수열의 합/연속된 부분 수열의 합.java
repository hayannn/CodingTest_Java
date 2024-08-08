import java.util.*;

/*알고리즘
1. start 및 end 선언 및 초기화, answer 초기값은 0으로 초기화
2. sequence의 합인 sum 선언
3. sum += sequence[j++]로 합 구하기
4. sum -= sequence[i++]로 다시 축소하기
4. sum == k라면 -> sequence.length 반환하기
*/

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[0];
        
        int minLength = Integer.MAX_VALUE;
        
        int start = -1;
        int end = -1;
        int sum = 0;
        
        int i = 0;
        int j = 0;

        while(j < sequence.length){
            sum += sequence[j++];
            
            while(sum > k && i < j){
                sum -= sequence[i++];
            }

            if(sum == k){
                if(j - i < minLength){
                    minLength = j - i;
                    start = i;
                    end = j - 1;
                }
            }
        }
        
        answer = new int[]{start, end};
        
        return answer;
    }
}