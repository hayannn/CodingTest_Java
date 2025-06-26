class Solution {
    public int[] solution(int n) {
        int total = n * (n + 1) / 2;
        int[][] matrix = new int[n][n];
        int x = -1, y = 0; // 시작 위치 (초기값)
        int num = 1; // 채울 숫자

        // 방향별 채우기
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                switch (i % 3) {
                    case 0: x++; break; // 아래
                    case 1: y++; break; // 오른쪽
                    case 2: x--; y--; break; // 대각선 위
                }
                matrix[x][y] = num++;
            }
        }
        
        int[] answer = new int[total];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = matrix[i][j];
            }
        }
        return answer;
    }
}