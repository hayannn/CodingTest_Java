/* 알고리즘
- 현재 영역이 모두 같은 숫자인지 확인
  - 만약 0 또는 1로만 이루어져 있다면 해당 숫자의 개수를 증가
- 같지 않다면 4개로 나눠서 확인
*/

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        compress(arr, 0, 0, arr.length, answer);
        return answer;
    }

    private void compress(int[][] arr, int x, int y, int size, int[] answer) {
        if (isUniform(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        int half = size / 2;
        int[][] offsets = {{0, 0}, {0, half}, {half, 0}, {half, half}};
        
        for (int[] offset : offsets) {
            compress(arr, x + offset[0], y + offset[1], half, answer);
        }
    }

    public boolean isUniform(int[][] arr, int x, int y, int size) {
        int val = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        return true;
    }
}