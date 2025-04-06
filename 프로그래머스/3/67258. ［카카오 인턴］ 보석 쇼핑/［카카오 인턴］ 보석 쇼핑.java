import java.util.*;

/* 알고리즘
- 슬라이딩 윈도우(left, right)
- right 포인터로 윈도우 확장하면서 보석을 map에 카운팅
- map.size()가 전체 보석 종류 개수와 같아지면 -> 모든 보석 포함
- left 이동
- 최소 구간 길이 -> 갱신
*/

class Solution {
    public int[] solution(String[] gems) {
        int totalKinds = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (right < gems.length) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            right++;

            while (map.size() == totalKinds) {
                if (right - left < minLen) {
                    minLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right;
                }

                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
        }

        return answer;
    }
}