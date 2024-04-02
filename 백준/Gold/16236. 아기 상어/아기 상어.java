import java.util.*;

class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        // 배열 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        // BFS 진행 및 출력
        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[] start = find();
        int sharkX = start[0];
        int sharkY = start[1];
        int sharkSize = 2; // 아기 상어 크기
        int eatCount = 0; // 먹은 물고기 수
        int moveCount = 0; // 이동 횟수

        while (true) {
            visited = new boolean[N][N];
            queue.clear();
            queue.add(new int[]{sharkX, sharkY, 0});
            visited[sharkX][sharkY] = true;
            boolean found = false;

            ArrayList<int[]> eatList = new ArrayList<>();

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                int dist = now[2];

                if (map[x][y] != 0 && map[x][y] < sharkSize) {
                    eatList.add(new int[]{x, y, dist});
                    found = true;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] <= sharkSize) {
                        queue.add(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }

            if (!found) {
                return moveCount;
            }

            Collections.sort(eatList, (a, b) -> {
                if (a[2] == b[2]) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
                return a[2] - b[2];
            });

            int[] target = eatList.get(0);
            int targetX = target[0];
            int targetY = target[1];
            int targetDist = target[2];

            map[targetX][targetY] = 0;
            sharkX = targetX;
            sharkY = targetY;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }

            moveCount += targetDist;
        }
    }

    static int[] find() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}