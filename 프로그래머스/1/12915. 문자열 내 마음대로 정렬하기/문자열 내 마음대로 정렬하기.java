import java.util.*;

/* 알고리즘
1. 각 문자열 앞에 n번째 문자를 붙여서 -> 리스트로 저장
2. 리스트 정렬 -> n번째 문자 기준
3. 앞에 붙인 문자를 제거 -> 원래 문자열로 복원
*/

class Solution {
    public String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                .sorted((s1, s2) -> {
                    if (s1.charAt(n) == s2.charAt(n)) {
                        return s1.compareTo(s2);
                    }
                    return Character.compare(s1.charAt(n), s2.charAt(n));
                }).toArray(String[]::new);
    }
}