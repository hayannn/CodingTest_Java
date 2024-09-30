import java.util.*;

/* 알고리즘
- 예약 시작(inTime)과 종료(outTime) 시간을 분 단위로 변환하기
- 예약 시작 시점(inTime)에 방을 하나 사용 + 예약 종료 시점에 청소 시간(CLEAN_TIME)을 더해 방 사용을 종료
- 각 시간별 방 사용 변화를 기록한 배열에서 누적 값 계산
    - 특정 시점에 사용 중인 방 개수를 확인
- 최소 방 개수 찾기
*/

class Solution {
    private static final int MAX_TIME = 1_450;
    private static final int HOUR = 60;
    private static final int CLEAN_TIME = 10;

    public static int solution(String[][] book_time) {
        
        int answer = 0;
        int[] rooms = new int[MAX_TIME];

        for (String[] time : book_time) {
            String inTime = time[0];
            String outTime = time[1];

            // 시간을 직접 계산하는 부분을 메서드 없이 인라인으로 처리
            String[] inSplit = inTime.split(":");
            int inMinutes = (Integer.parseInt(inSplit[0]) * HOUR) + Integer.parseInt(inSplit[1]);
            
            String[] outSplit = outTime.split(":");
            int outMinutes = (Integer.parseInt(outSplit[0]) * HOUR) + Integer.parseInt(outSplit[1]);

            // 시간 계산 및 배열 업데이트
            rooms[inMinutes] += 1;
            rooms[outMinutes + CLEAN_TIME] -= 1;
        }

        // 누적된 방의 최대 사용량 계산
        for (int i = 1; i < MAX_TIME; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }
}