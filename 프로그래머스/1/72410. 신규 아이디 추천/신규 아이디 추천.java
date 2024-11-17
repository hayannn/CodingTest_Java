import java.util.*;

/* 알고리즘
- 정규 표현식 사용하기!
  - 각 단게별로 규칙에 맞는 아이디 추천해주는 알고리즘 작성
*/

class Solution {
    public String solution(String new_id) {
        // 1
        String id = new_id.toLowerCase();

        // 2
        id = id.replaceAll("[^-_.a-z0-9]", "");

        // 3
        id = id.replaceAll("[.]{2,}", ".");

        // 4
        id = id.replaceAll("^[.]|[.]$", "");

        // 5
        if (id.isEmpty()) {
            id = "a";
        }

        // 6
        if (id.length() >= 16) {
            id = id.substring(0, 15).replaceAll("[.]$", "");
        }

        // 7
        while (id.length() < 3) {
            id += id.charAt(id.length() - 1);
        }

        return id;
    }
}