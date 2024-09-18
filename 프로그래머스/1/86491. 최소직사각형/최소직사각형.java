import java.util.*;

/*알고리즘
- 가로 세로의 길이를 비교
    - 가로 : 긴 사이즈, 세로 : 짧은 사이즈로 구성해서 max 구하기
- 결과값: 가로 최대값 * 세로 최대값
*/

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_row = 0;
        int max_col = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){ //가로 세로 회전
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            if(max_row < sizes[i][0]) max_row = sizes[i][0];
            if(max_col<sizes[i][1]) max_col = sizes[i][1];
        }       
        answer = max_col*max_row;
        
        return answer;
    }
}