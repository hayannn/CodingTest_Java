import java.util.*;

/*알고리즘
- 숫자를 문자열로 변환해서 각 자릿수 더하기
- 숫자가 자릿수 합으로 나누어떨어지면 하샤드 수 true로 반환
  - 그렇지 않은 경우 false 반환
*/

class Solution {
    public boolean solution(int x) {
        int allNiven = 0;
        String numStr = Integer.toString(x);
        
        for (int i = 0; i < numStr.length(); i++) {
            allNiven += numStr.charAt(i) - '0'; // 문자에서 '0'을 빼서 정수로 변환
        }
        
        return x % allNiven == 0;
    }
}
