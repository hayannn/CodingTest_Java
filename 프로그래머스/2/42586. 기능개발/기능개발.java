import java.util.*;

/* 알고리즘
- Queue 이용(그리디 알고리즘)
- 작업 완료까지 남은 일수 계산하기(for문)
  - 작업 완료 시까지의 필요 일수를 -> 계산해서 Queue에 저장
- 배포
  - 첫번째 작업을 기준으로 이후 작업들과 비교 -> 완료 가능한 작업들을 묶어서 한번에 배포
- 저장
  - 리스트로 저장해서 -> 배열 반환

*/

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }

        int maxDay = days[0];
        int count = 0;

        for (int day : days) {
            if (day <= maxDay) {
                count++;
            } else {
                result.add(count);
                count = 1;
                maxDay = day;
            }
        }
        result.add(count);
        
        int[] answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}