import java.util.*;

/* 알고리즘
- 그래프 인접 리스트 -> 양방향 도로
- 다익스트라 알고리즘 : 1번 마을부터 각 마을까지 최단 거리 계산
    - PriorityQueue 사용
    - 거리가 줄어들 때만 큐에 추가
- 거리 배열에서 K 이하인 마을의 수 카운트
*/

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int[] r : road) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0], cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] next : graph.get(now)) {
                int to = next[0], time = next[1];
                if (dist[to] > cost + time) {
                    dist[to] = cost + time;
                    pq.offer(new int[]{to, dist[to]});
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }

        return count;
    }
}