import java.util.*;

/* 알고리즘
- 최소 힙 생성 : 모든 음식의 스코빌 지수를 작은 순서대로 관리
- 반복 섞기
  - 가장 작은 두 값을 꺼내 새 스코빌 계산(첫번째 + 두번째*2)
  - 새로운 값 -> 힙에 추가, 횟수 증가
- 가장 작은 값이 K 이상이면 종료, 불가능한 경우 -1을 반환
*/

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + (second * 2);
            pq.add(newScoville);
            answer++;
        }
        
        if (pq.peek() < K) {
            return -1;
        }

        return answer;
    }
}