/* 알고리즘
1. participant 배열 정렬
2. completion 배열 정렬
3. 두 배열을  equals 비교 -> 없는 것만 participant 배열에 담아서 출력
*/

import java.util.*;

class Solution {
    
    //static int i;
    
    public String solution(String[] participant, String[] completion) {
        
        // 1. participant 배열 정렬
        Arrays.sort(participant);
        
        // 2. completion 배열 정렬
        Arrays.sort(completion);
        
        int i;
        
        // 3. 두 배열 비교 -> 없는 것만 participant 배열에 담아서 출력
        for(i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }
}