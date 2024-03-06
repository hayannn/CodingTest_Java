//오후 5시 42분 시작 ~ 6시 28분 종료
import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) { 
        long sum = 0;
        
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        for(int i=0; i<food_times.length; i++){
            sum += food_times[i];
        }
        
        if(sum <= k){
            return -1;
        }
        
        // 시간이 작은 음식부터 빼서 정렬 -> 우선순위 큐 사용
        PriorityQueue<Food> queue = new PriorityQueue<>();
        for(int i=0; i <food_times.length; i++){
            // 우선순위 큐에 add -> 음식 시간, 음식 번호 형태(결과 리턴은 음식 번호로 해야하기 때문)
            queue.add(new Food(i+1, food_times[i]));
        }
        
        sum = 0; //초기화
        long lastEnd = 0; //직전에 다 먹은 음식 시간
        long after = food_times.length; //남은 음식 개수
        
        //sum + (현재 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while(sum + ((queue.peek().getTime() - lastEnd) * after) <= k){
            int now = queue.poll().getTime();
            sum += (now - lastEnd) * after; 
            lastEnd = now; // 비교 1회가 끝나면 -> 이전 음식 시간이 업데이트 되어야 함.
            after--;
        }
        
        //몇 번째 음식인지 출력
        ArrayList<Food> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        
        // 음식의 번호 기준 정렬
        result.sort(Comparator.comparingInt(Food::getIndex));
        
        return result.get((int) ((k-sum) % after)).getIndex();
    }
    
    class Food implements Comparable<Food> {
        int index;
        int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }

        // 시간이 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Food other) {
            return Integer.compare(this.time, other.getTime());
        }
    }
}