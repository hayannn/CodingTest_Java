/*
알고리즘
- 알파벳 이동 구현
  - 알파벳 범위를 벗어나면 -> % 26
  - 공백 유지
*/
class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                answer.append(ch);
                continue;
            }
            if (ch >= 'a' && ch <= 'z') {
                answer.append((char) ((ch - 'a' + n) % 26 + 'a'));
                continue;
            }
            answer.append((char) ((ch - 'A' + n) % 26 + 'A'));
        }
        return answer.toString();
    }
}