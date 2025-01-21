import java.util.*;
import static java.util.stream.Collectors.*;

/* 알고리즘
- Arrays.stream 이용
  - 의상 종류에 따라 그룹핑, 의상 이름 맵핑을 통해 그룹화 개수 구하기
  - collect로 조합 개수 구하기
    - reducing 연산을 통해 의상을 입지 않는 경우를 포함
*/

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Long> categoryCount = Arrays.stream(clothes)
                .collect(groupingBy(c -> c[1], counting()));

        return categoryCount.values().stream()
                .map(count -> count + 1)
                .reduce(1L, (a, b) -> a * b)
                .intValue() - 1;
    }
}