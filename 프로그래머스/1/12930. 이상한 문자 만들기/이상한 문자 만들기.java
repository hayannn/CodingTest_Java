import java.util.*;

/*알고리즘
1. 문자열 split으로 자르기
2. 문자열을 나누고 짝수 홀수 구분해서 조건문 작성
*/

class Solution {
  public String solution(String s) {
        String answer = "";
        int count = 0;
        String[] array = s.split("");

        for (int i = 0; i < array.length; i++) {
            String ds = array[i];
            if (ds.equals(" ")) {
                count = 0;
            } else {
                count++;
            }
            
            if (count % 2 == 0) {
                answer += ds.toLowerCase();
            } else {
                answer += ds.toUpperCase();
            }
        }
      return answer;
  }
}