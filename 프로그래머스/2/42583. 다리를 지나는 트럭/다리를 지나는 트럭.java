import java.util.*;

/* 알고리즘
- 초기화
  - 다리 Queue<Integer> -> 길이만큼 0을 채우는 방식
  - totalWeight = 0, time = 0, index = 0
- while문으로 트럭 이동
  - time++
  - 다리에서 트럭 제거 -> totalWeight 감소
  - 새 트럭이 다리에 올라갈 수 있으면 추가 (totalWeight + 트럭 무게 <= 하중)
  - 못 올라가면 0 추가 (continue로 다음 루프)
- 마지막 트럭이 다리 건너는 시간 추가
*/

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int totalWeight = 0, time = 0, index = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (index < truck_weights.length) {
            time++;
            totalWeight -= bridge.poll();
            if (totalWeight + truck_weights[index] > weight) {
                bridge.offer(0);
                continue;
            }
            bridge.offer(truck_weights[index]);
            totalWeight += truck_weights[index];
            index++;
        }
        
        return time + bridge_length;
    }
}