/* 알고리즘
- (i, j) 위치에 1이 있는 경우
    - (i-1, j), (i, j-1), (i-1, j-1) 위치의 값 중 최소값 구하기
    - 해당 최소값에 1을 더해 board[i][j] 갱신(이 위치에서 만들 수 있는 가장 큰 정사각형의 한 변의 길이)
- 모든 위치에서 계산 후, 최대값의 제곱 반환
*/

class Solution {
    public int solution(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int max = 0;

        for (int i = 0; i < rows; i++) {
            max = Math.max(max, board[i][0]);
        }

        for (int j = 0; j < cols; j++) {
            max = Math.max(max, board[0][j]);
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(
                        Math.min(board[i - 1][j], board[i][j - 1]),
                        board[i - 1][j - 1]
                    ) + 1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }

        return max * max;
    }
}