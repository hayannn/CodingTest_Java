class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;

        // 자물쇠 크기 3배 확장 및 입력 조건 다시 넣어주기
        int[][] lockT = new int[N * 3][N * 3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                lockT[i + N][j + N] = lock[i][j];
            }
        }

        // 360도 회전(90도 회전 x4) 수행
        for (int i = 0; i < 4; i++) {
            key = spin(key);
            for (int x = 0; x < N * 2; x++) {
                for (int y = 0; y < N * 2; y++) {
                    if (check(lockT, key, x, y, M, N)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int[][] spin(int[][] key) {
        int M = key.length;
        int[][] spined = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                spined[i][j] = key[M - 1 - j][i];
            }
        }

        return spined;
    }

    private boolean check(int[][] lockT, int[][] key, int startX, int startY, int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                lockT[startX + i][startY + j] += key[i][j];
            }
        }

        // 중앙 부분이 모두 1인지 확인
        for (int i = N; i < N * 2; i++) {
            for (int j = N; j < N * 2; j++) {
                if (lockT[i][j] != 1) {
                    // 원래 상태로 되돌리기
                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {
                            lockT[startX + k][startY + l] -= key[k][l];
                        }
                    }
                    return false;
                }
            }
        }

        // 원래 상태로 되돌리기
        for (int k = 0; k < M; k++) {
            for (int l = 0; l < M; l++) {
                lockT[startX + k][startY + l] -= key[k][l];
            }
        }

        return true;
    }
}