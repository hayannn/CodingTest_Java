import java.util.*;

/*알고리즘
- 도착 시간을 기준 작업 정렬
- 우선 순위 큐로 작업을 소요 시간 순으로 처리
- 현재 시간 : 도착한 작업은 큐에 넣고, 큐에서 가장 소요 시간이 짧은 작업을 꺼냄
- 대기 시간 : 각 작업 대기 시간 구해서 합평균으로 대기 시간 반환
*/

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int time = 0;
        int total = 0;
        int count = 0;
        int index = 0;

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index++]);
            }

            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] current = pq.poll();
                time += current[1];
                total += time - current[0];
                count++;
            }
        }
        int answer = total / jobs.length;
        
        return answer;
    }
}