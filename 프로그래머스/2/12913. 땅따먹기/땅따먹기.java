/* 알고리즘

- 첫 번째 행은 그대로 사용
- 1번 행부터 마지막 행까지 반복하면서 갱신
    - land[i][j]
    - 이전 행의 동일 열을 제외한 값들 중 최대값 구하기
    - 최대값을 현재 위치 값에 더하기
- 마지막 행에서 최댓값을 찾아 반환

*/
class Solution {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] += max;
            }
        }
        int[] last = land[land.length - 1];
        return Math.max(Math.max(last[0], last[1]), Math.max(last[2], last[3]));
    }
}