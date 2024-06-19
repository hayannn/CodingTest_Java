import java.util.*;

public class Main {

    static int N;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean foundSolution;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String map = sc.nextLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = map.charAt(j * 2); // 공백이 있으므로 j * 2
            }
        }

        foundSolution = false;
        dfs(0);

        if (foundSolution) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void dfs(int count) {
        if (count == 3) { // 장애물 3개 설치
            if (check()) {
                foundSolution = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'X') {
                    arr[i][j] = 'O';
                    dfs(count + 1);
                    if (foundSolution) return; // 해결책을 찾으면 더 이상 탐색하지 않음
                    arr[i][j] = 'X';
                }
            }
        }
    }

    // 감시를 피할 수 있는지 확인하는 메서드
    public static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'T') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (arr[nx][ny] == 'S') {
                                return false; // 학생 발견 시 false
                            }
                            if (arr[nx][ny] == 'O') {
                                break; // 장애물 발견 시 탐색 중지
                            }
                            nx += dx[k];
                            ny += dy[k];
                        }
                    }
                }
            }
        }
        return true; // 모든 선생님이 학생을 발견하지 못하는 경우에 해당
    }
}