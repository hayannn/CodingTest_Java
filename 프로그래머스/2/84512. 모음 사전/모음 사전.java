import java.util.*;

/*알고리즘
- DFS로 단어 생성
    - 빈 문자열 -> "A", "E", "I", "O", "U"를 하나씩 추가해 단어 만들기
    - 최대 5글자(count 증가)
- 목표 단어(word)를 찾으면 -> 종료
    - 생성한 단어가 word와 같다면 -> answer를 count 값으로
- word를 찾으면 바로 return
*/

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static int count, answer;
    
    public int solution(String word) {
        count = 0;
        answer = 0;
        dfs("", word, 0);
        return answer;
    }

    static void dfs(String str, String target, int len) {
        if (str.equals(target)) {
            answer = count;
            return;
        }
        if (len == 5) return;
        
        for (int i = 0; i < 5; i++) {
            count++;
            dfs(str + words[i], target, len + 1);
            if (answer > 0) return;
        }
    }
}