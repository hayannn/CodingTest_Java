import java.util.*;

/*알고리즘
1. 시간 int형으로 변환
2. 현재 위치가 시작과 종료 구간 사이에 있다면
    - 오프닝 종료 시간으로 강제 이동하기
3. command 순회
    - prev라면 -> 10초 이전으로 점프(0초 이상)
    - next라면 -> 10초 이후으로 점프(동영상 맥스 길이 안넘게)
    - 오프닝 시간 -> 다시 오프닝 종료 시간으로 점프
*/

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int len_s = second(video_len);
        int current_s = second(pos);
        int op_start_s = second(op_start);
        int op_end_s = second(op_end);

        if(current_s >= op_start_s && current_s <= op_end_s) {
            current_s = op_end_s;
        }
        
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            if (command.equals("prev")) {
                current_s = Math.max(current_s - 10, 0);
            }

            if (command.equals("next")) {
                current_s = Math.min(current_s + 10, len_s);
            }

            if (current_s >= op_start_s && current_s <= op_end_s) {
                current_s = op_end_s;
            }
        }


        int minute = current_s / 60;
        int second = current_s % 60;

        String result = String.format("%02d:%02d", minute, second);
        return result;

    }
    
    public static int second(String time) {
        String[] timeParts = time.split(":");
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);
        return minutes * 60 + seconds;
    }
}