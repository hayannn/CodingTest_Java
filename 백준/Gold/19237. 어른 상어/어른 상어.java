import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] sharks;
    static int[] sharkDir;
    static int[][][] smell;
    static int[][][] priority;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] now;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        // 상어의 초기 위치와 냄새 정보 입력 받기
        sharks = new int[N][N];
        smell = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sharks[i][j] = sc.nextInt();
                if (sharks[i][j] != 0) {
                    smell[i][j][0] = sharks[i][j];
                    smell[i][j][1] = K;
                }
            }
        }

        // 상어의 초기 방향 입력 받기
        sharkDir = new int[M];
        for (int i = 0; i < M; i++) {
            sharkDir[i] = sc.nextInt();
        }

        // 상어의 방향 우선순위 입력 받기
        priority = new int[M][4][4];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                for (int l = 0; l < 4; l++) {
                    priority[i][j][l] = sc.nextInt();
                }
            }
        }

        int time = 0;
        while (true) {
            SmellInfo();
            int[][] next = moveShark();
            if (next == null) {
                System.out.println(-1);
                break;
            }
            sharks = next;
            time++;

            if (time > 1000) {
                System.out.println(-1);
                break;
            }

            if (sharkOne()) {
                System.out.println(time);
                break;
            }
        }
    }

    // 냄새 정보 갱신
    static void SmellInfo() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smell[i][j][1] > 0) {
                    smell[i][j][1]--;
                }
                if (sharks[i][j] != 0) {
                    smell[i][j][0] = sharks[i][j];
                    smell[i][j][1] = K;
                }
            }
        }
    }

    // 상어 이동
    static int[][] moveShark() {
        now = new int[N][N]; // 이동 후의 상어 위치를 저장할 배열

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (sharks[x][y] != 0) {
                    int direction = sharkDir[sharks[x][y] - 1];
                    boolean find = false;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[priority[sharks[x][y] - 1][direction - 1][i] - 1];
                        int ny = y + dy[priority[sharks[x][y] - 1][direction - 1][i] - 1];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (smell[nx][ny][1] == 0) {
                                sharkDir[sharks[x][y] - 1] = priority[sharks[x][y] - 1][direction - 1][i];
                                if (now[nx][ny] == 0) {
                                    now[nx][ny] = sharks[x][y];
                                } else {
                                    now[nx][ny] = Math.min(now[nx][ny], sharks[x][y]);
                                }
                                find = true;
                                break;
                            }
                        }
                    }
                    if (find) {
                        continue;
                    }

                    // 냄새가 없는 곳이 없는 경우
                    for (int index = 0; index < 4; index++) { // 자신의 냄새가 있는 곳으로 이동
                        int nx = x + dx[priority[sharks[x][y] - 1][direction - 1][index] - 1];
                        int ny = y + dy[priority[sharks[x][y] - 1][direction - 1][index] - 1];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (smell[nx][ny][0] == sharks[x][y]) {
                                sharkDir[sharks[x][y] - 1] = priority[sharks[x][y] - 1][direction - 1][index];
                                now[nx][ny] = sharks[x][y];
                                break;
                            }
                        }
                    }
                }
            }
        }

        // 모든 상어의 이동이 끝난 후, 새로운 상어 배열을 반환
        // 이때, 새로운 상어 배열이 비어있는 경우는 상어가 모두 죽은 경우
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (now[i][j] != 0) {
                    return now;
                }
            }
        }
        return null;
    }

    // 한 마리의 상어만 남았는지 확인
    static boolean sharkOne() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sharks[i][j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}