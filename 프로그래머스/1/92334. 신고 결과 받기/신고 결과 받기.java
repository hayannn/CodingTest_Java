import java.util.*;

/* 알고리즘
- 사용자별 신고자 저장을 위한 해시맵 생성, 인덱스 매핑
- report 배열
  - 각 신고 내역 -> 신고받은 사용자 정보 저장(중복 방지 용도)
- 사용자가 받은 신고 수가 k 이상
  - 해당 사용자들을 신고한 사람들의 신고 횟수 증가
- 알림 횟수를 배열로 반환
*/

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> userIndexMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
            userIndexMap.put(id_list[i], i);
        }

        for (String entry : report) {
            String[] parts = entry.split(" ");
            reportMap.get(parts[1]).add(parts[0]);
        }

        for (String user : id_list) {
            Set<String> reporters = reportMap.get(user);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    answer[userIndexMap.get(reporter)]++;
                }
            }
        }
        return answer;
    }
}