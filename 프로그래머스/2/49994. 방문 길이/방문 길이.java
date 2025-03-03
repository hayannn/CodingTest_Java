/* 알고리즘
- 이동 방향 매핑 (U, D, L, R)
- 초기 위치를 (5, 5)로 설정 (11×11 격자)
- 이동이 격자 범위(0~10) 내인지 확인
- 해당 길을 처음 방문한 경우 -> 길 방문 기록을 저장하고 카운트 증가
- 현재 위치를 업데이트
*/

import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        int x = 5, y = 5;
        
        Map<Character, int[]> moves = Map.of(
            'U', new int[]{0, 1}, 'D', new int[]{0, -1},
            'L', new int[]{-1, 0}, 'R', new int[]{1, 0}
        );

        for (char dir : dirs.toCharArray()) {
            int nx = x + moves.get(dir)[0];
            int ny = y + moves.get(dir)[1];

            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;

            String path = x + "" + y + "" + nx + "" + ny;
            String reversePath = nx + "" + ny + "" + x + "" + y;

            if (!visited.contains(path)) {
                visited.add(path);
                visited.add(reversePath);
            }

            x = nx;
            y = ny;
        }

        return visited.size() / 2; // 양방향
    }
}
