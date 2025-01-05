import java.util.*;

/* 알고리즘
- 문자열을 한 문자씩 순차 확인
  - 각 문자가 스택의 맨 위 값과 같으면 -> 짝으로 확인 + 문자 제거
  - 그렇지 않으면 -> 현재 문자를 스택에 추가
- 결과 : 스택이 비어 있으면 짝이 맞는다고 판단하고 1 반환, 스택에 문자가 남아 있으면 짝이 맞지 않는다고 판단하고 0 반환
*/

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}