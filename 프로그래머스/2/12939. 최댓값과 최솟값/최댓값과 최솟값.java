import java.util.*;

/* 알고리즘
- 문자열을 공백을 기준으로 분리 -> 정수형으로 변환
- 최솟값과 최댓값 계산
  - 초기 min: Integer.MAX_VALUE
  - 초기 max: Integer.MIN_VALUE
- min, max 갱신
- 최솟값과 최댓값 -> 출력(공백으로 구분)
*/

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for (String num : str) {
            int n = Integer.parseInt(num);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        return min + " " + max;
    }
}
