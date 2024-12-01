import java.util.*;

/* 
알고리즘
- 문자열 시계방향 회전 -> 괄호의 짝이 올바른지 확인
  - 회전한 문자열에서 스택으로 괄호의 짝 실제 확인
  - 카운트 리준 : 짝이 하나라도 맞지 않으면 안됨!
*/

public class Solution {
    static public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            String rotatedStr = s.substring(i) + s.substring(0, i);
            
            for (char c : rotatedStr.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (!stack.isEmpty() && isValidPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }

    static boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') || 
               (open == '{' && close == '}') || 
               (open == '[' && close == ']');
    }
}