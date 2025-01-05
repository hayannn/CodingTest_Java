import java.util.*;

/* 알고리즘
- 중복 단어 체크
  - Set으로 등장한 단어 체크
  - add 메서드 -> 단어가 이미 있으면 false를 반환
- 끝말잇기 규칙 체크
  - 현재 단어의 첫 글자와 이전 단어의 마지막 글자가 일치하는지 확인
- 규칙 위반 : 해당 사람의 번호와 회차 반환
*/

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (!usedWords.add(words[i]) || (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
        }
        return new int[]{0, 0};
    }
}
