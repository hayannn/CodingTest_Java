import java.util.*;

/* 알고리즘
- 초기화
  - 모든 프로세스를 (index, priority) 형태로 Deque
  - 우선순위만 따로 리스트에 저장한 후, 내림차순 정렬
- 처리 과정
  - 큐에서 프로세스 하나씩 가장 높은 우선 순위와 비교
  - 우선 순위가 가장 높은 것만 제거, 실행 순서 ++
  - 우선순위 낮으면 다시 큐에 넣음
- 실행된 프로세스가 목표 location이면 실행 순서 반환

*/

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> deque = new ArrayDeque<>();
        List<Integer> sortedPriorities = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            deque.offer(new int[]{i, priorities[i]});
            sortedPriorities.add(priorities[i]);
        }

        sortedPriorities.sort(Collections.reverseOrder());

        int count = 0;
        int index = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();

            if (current[1] != sortedPriorities.get(index)) {
                deque.offer(current);
                continue;
            }

            count++;
            index++;

            if (current[0] == location) {
                return count;
            }
        }
        return count;
    }
}