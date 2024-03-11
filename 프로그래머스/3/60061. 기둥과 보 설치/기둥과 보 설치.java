//오후 7시 45분 ~ 8시 27분
import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> result = new ArrayList<>();  // 최종 결과를 저장할 리스트

        boolean[][] leng = new boolean[n + 1][n + 1];  // 기둥 정보
        boolean[][] wid = new boolean[n + 1][n + 1];    // 보 정보

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];

            if (b == 1) {  // 설치하는 경우
                if (a == 0) {  // 기둥 설치
                    if (y == 0 || leng[x][y - 1] || (x > 0 && wid[x - 1][y]) || wid[x][y]) {
                        leng[x][y] = true;
                    }
                } else {  // 보 설치
                    if ((leng[x][y - 1] || leng[x + 1][y - 1]) || ((x > 0 && wid[x - 1][y]) && (x < n && wid[x + 1][y]))) {
                        wid[x][y] = true;
                    }
                }
            } else {  // 삭제하는 경우
                if (a == 0) {  // 기둥 삭제
                    leng[x][y] = false;
                    boolean valid = true;

                    // 기둥 삭제 후 유효성 검사
                    if ((y < n && leng[x][y + 1] && !isValidLeng(x, y + 1, leng, wid)) ||
                            (x > 0 && wid[x - 1][y + 1] && !isValidWid(x - 1, y + 1, leng, wid)) ||
                            (wid[x][y + 1] && !isValidWid(x, y + 1, leng, wid))) {
                        valid = false;
                        leng[x][y] = true;  // 삭제 전 상태로 복구
                    }

                    if (!valid) continue;  // 유효하지 않으면 삭제 취소
                } else {  // 보 삭제
                    wid[x][y] = false;
                    boolean valid = true;

                    // 보 삭제 후 유효성 검사
                    if (((leng[x][y] && !isValidLeng(x, y, leng, wid)) ||
                            (x < n && leng[x + 1][y] && !isValidLeng(x + 1, y, leng, wid))) ||
                            ((x > 0 && wid[x - 1][y] && !isValidWid(x - 1, y, leng, wid)) ||
                                    (x < n && wid[x + 1][y] && !isValidWid(x + 1, y, leng, wid)))) {
                        valid = false;
                        wid[x][y] = true;  // 삭제 전 상태로 복구
                    }

                    if (!valid) continue;  // 유효하지 않으면 삭제 취소
                }
            }
        }

        // 최종 결과를 리스트에 저장
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (leng[i][j]) result.add(new int[]{i, j, 0});
                if (wid[i][j]) result.add(new int[]{i, j, 1});
            }
        }

        // 정렬 후 배열로 변환하여 반환
        Collections.sort(result, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        return result.toArray(new int[0][]);
    }

    private boolean isValidLeng(int x, int y, boolean[][] leng, boolean[][] wid) {
        return y == 0 || leng[x][y - 1] || (x > 0 && wid[x - 1][y]) || wid[x][y];
    }

    private boolean isValidWid(int x, int y, boolean[][] leng, boolean[][] wid) {
        return (leng[x][y - 1] || leng[x + 1][y - 1]) || ((x > 0 && wid[x - 1][y]) && (x < wid.length - 1 && wid[x + 1][y]));
    }
}
