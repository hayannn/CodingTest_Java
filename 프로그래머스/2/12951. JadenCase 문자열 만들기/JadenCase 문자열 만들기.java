import java.util.*;

/*알고리즘
- 문자열 나누기(공백 기준)
- 단어 첫 글자 : 대문자, 나머지 : 소문자
- 공백 제거하여 결과 반환
*/

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] arr = s.split(" ", -1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 0) {
                answer.append(arr[i].substring(0, 1).toUpperCase())
                      .append(arr[i].substring(1).toLowerCase());
            }
            answer.append(" ");
        }

        return answer.substring(0, answer.length() - 1);
    }
}