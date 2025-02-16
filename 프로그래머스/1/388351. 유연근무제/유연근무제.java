import java.util.*;
/*알고리즘
- 출근 희망 시각에 10분을 더한 시각 계산
  - 10분 더하기
- 출근 시각 확인
  - 7일 : 출근 시각 확인
  - startday부터 7일간 요일 계산
  - 토요일(5), 일요일(6) 제외
  - 출근 시각이 설정된 시간에 +10분을 더한 시간보다 늦으면 상품을 못 받음
*/
public class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        int[] endTimes = new int[schedules.length];
        for (int i = 0; i < schedules.length; i++) {
            int hour = schedules[i] / 100;
            int minute = schedules[i] % 100;
            int newTime = (hour * 100 + minute + 10);
            if (newTime % 100 >= 60) {
                newTime += 40;
            }
            endTimes[i] = newTime;
        }

        for (int i = 0; i < timelogs.length; i++) {
            boolean isEligible = true;
            for (int j = 0; j < 7; j++) {
                int actualDay = (startday + j - 1) % 7;
                if (actualDay == 5 || actualDay == 6) {
                    continue;
                }

                if (timelogs[i][j] > endTimes[i]) {
                    isEligible = false;
                    break;
                }
            }

            if (isEligible) {
                answer++;
            }
        }
        
        return answer;
    }
}