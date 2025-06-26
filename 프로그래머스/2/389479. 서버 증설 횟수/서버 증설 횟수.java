import java.util.*;

/* 알고리즘
1. 활성 서버 추적
- 현재 가동 중인 서버 수를 실시간 관리 : runningServers 사용
- 서버 반납 시점 기록 및 스케줄링 : shutDownSchedule 배열 사용

2. 서버 반납 처리
- 시간 t 시작 -> shutDownSchedule[t]에 기록된 서버 수를 runningServers에서 빼는 방식으로 진행
- players[t] / m -> 현재 시점에 필요한 최소 서버 수 계산(정수)
- runningServers < requiredServers인 경우 차액만큼 서버 증설
    - 차액 : add = requiredServers - runningServers
- 증설된 서버 -> k 시간 후 반납 예정 -> 서버 수명이 종료되면 자동 반납
*/

class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        int[] shutDownSchedule = new int[n + k]; // t+k 시점에 반납될 서버 수
        int runningServers = 0;   // 지금 돌고 있는 서버 수
        int totalAdded = 0;   // 총 증설된 서버 수(최종 값)

        for (int t = 0; t < n; t++) {
            // k 시간이 지난 후 반납될 서버 제거
            runningServers -= shutDownSchedule[t];

            // 추가 서버 수
            int requiredServers = players[t] / m;

            
            //부족한 만큼 증설
            if (runningServers < requiredServers) {
                int add = requiredServers - runningServers;
                totalAdded     += add;
                runningServers += add;

                // k 시간 후 서버 반납
                if (t + k < shutDownSchedule.length) {
                    shutDownSchedule[t + k] += add;
                }
            }
        }
        return totalAdded;
    }
}