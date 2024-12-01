import java.util.*;
/*
알고리즘
1. 여는 괄호 '('를 만나면 스택에 추가
2. 닫는 괄호 ')'를 만나면 스택에서 제거
  - 스택이 비었는데 닫는 괄호가 나오면 false
3. 순회가 끝나고 스택이 비어 있으면 true, 아니면 false
*/

class Solution {
    boolean solution(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (--balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}