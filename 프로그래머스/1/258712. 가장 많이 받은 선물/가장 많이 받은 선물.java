import java.util.*;

/* 알고리즘
- 해시맵 사용
- 선물을 준 사람과 받은 사람 기록
  - 선물 준 횟수 +1, 받은 횟수  -1로 -> giftDegree
  - giftGraph 배열에 선물 관계 기록
- 선물 관계 비교
  - 특정 친구가 다른 친구보다 더 많이 주거나 같다면
    - 선물 지수가 더 크다면 카운트 증가
- 가장 높은 값으로 갱신
- 가장 많이 선물을 주고받은 경우의 수 반환
*/

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        Map<String, Integer> friendIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendIndex.put(friends[i], i);
        }

        int[] giftDegree = new int[n];
        int[][] giftGraph = new int[n][n];

        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver = friendIndex.get(parts[0]);
            int receiver = friendIndex.get(parts[1]);

            giftDegree[giver]++;
            giftDegree[receiver]--;
            giftGraph[giver][receiver]++;
        }

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && (giftGraph[i][j] > giftGraph[j][i] || 
                    (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j]))) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}