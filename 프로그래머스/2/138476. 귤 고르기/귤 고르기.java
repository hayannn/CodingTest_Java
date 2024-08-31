import java.util.*;

/* 알고리즘
- HashMap으로 귤 크기별 개수를 담기
- 귤을 내림차순 정렬
-  다른 종류의 수 최소화 결과 -> k 개수만큼 담아야 함.
    - 귤 개수가 k개 이상인 경우까지 탐색하기
*/

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int i = 0;
        while (i < keyList.size()) {
            if (k <= 0) {
                break;
            }
            answer++;
            k -= map.get(keyList.get(i));
            i++;
        }    
        return answer;
    }
}