import java.util.*;

/* 알고리즘
- 각 order를 오름차순 정렬 -> 조합 기준 통일
- course 길이에 따라 가능한 조합을 백트래킹
- Map : 조합별 등장 횟수 카운팅
- 각 코스 길이마다 최고 빈도 조합만 넣기
- 최종 결과 오름차순 정렬하기
*/

class Solution {

    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int len : course) {
            Map<String, Integer> countMap = new HashMap<>();
            int max = 0;

            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                combination(chars, len, 0, "", countMap);
            }

            for (int cnt : countMap.values()) {
                if (cnt >= 2) {
                    max = Math.max(max, cnt);
                }
            }

            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == max && max >= 2) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    void combination(char[] arr, int len, int idx, String curr, Map<String, Integer> map) {
        if (curr.length() == len) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            combination(arr, len, i + 1, curr + arr[i], map);
        }
    }
}