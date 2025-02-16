/*알고리즘
- 창고 배열 생성 + 택배 상자를 지그재그로 배치
- num으로 행렬 찾기
- num이 있는 열에서 위에 있는 모든 상자의 개수를 세서 반환
*/
class Solution {
    public int solution(int n, int w, int num) {
        int h = (int) Math.ceil((double) n / w);

        int[][] warehouse = new int[h][w];
        
        int index = 1;
        for (int i = 0; i < h; i++) {
            if (i % 2 == 0) { // 왼쪽 -> 오른쪽
                for (int j = 0; j < w && index <= n; j++) {
                    warehouse[i][j] = index++;
                }
            } else { // 오른쪽 -> 왼쪽
                for (int j = w - 1; j >= 0 && index <= n; j--) {
                    warehouse[i][j] = index++;
                }
            }
        }

        int targetRow = -1, targetCol = -1;
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (warehouse[i][j] == num) {
                    targetRow = i;
                    targetCol = j;
                    break;
                }
            }
            if (targetRow != -1) break;
        }

        int count = 0;
        for (int i = h - 1; i >= targetRow; i--) {
            if (warehouse[i][targetCol] != 0) count++;
        }
        
        return count;
    }
}