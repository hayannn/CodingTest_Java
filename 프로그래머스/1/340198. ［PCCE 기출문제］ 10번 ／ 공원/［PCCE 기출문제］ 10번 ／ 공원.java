import java.util.*;

/* 알고리즘
1. mats 정렬
2. 큰 매트부터 비교해 배치가 가능한지 파악하기
3. 별도 메서드 - 매트 배치가 되는지(-1) 확인
4. 배치되는 가장 큰 매트를 찾아 -> 그 크기를 결과로(없다면 -1 반환)
*/

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        Arrays.sort(mats);

        for (int m = mats.length - 1; m >= 0; m--) {
            int size = mats[m];
            if (canPlaceMat(size, park, rows, cols)) {
                return size;
            }
        }
        
        return -1;
    }

    public boolean canPlaceMat(int size, String[][] park, int rows, int cols) {
        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                if (checkArea(i, j, size, park)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkArea(int startX, int startY, int size, String[][] park) {
        for (int x = startX; x < startX + size; x++) {
            for (int y = startY; y < startY + size; y++) {
                if (!park[x][y].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}