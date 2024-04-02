import java.util.*;

class Main {
    static int[][] map;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int startX;
    static int startY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];

        // 배열 입력 받기
        startX = 0;
        startY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }

        int result = 0;
        int sharkSize = 2;
        int count = 0;

        while (true) {
            int[] nearestFood = find(startX, startY, sharkSize);
            if (nearestFood == null) {
                break;
            }
            int targetX = nearestFood[0];
            int targetY = nearestFood[1];
            int dist = nearestFood[2];

            result += dist;
            map[targetX][targetY] = 0;
            count++;

            if (count == sharkSize) {
                sharkSize++;
                count = 0;
            }

            startX = targetX;
            startY = targetY;
        }

        System.out.println(result);
    }

    static int[] find(int startX, int startY, int sharkSize) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        int[] nFood = null;
        int minDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];

            if (map[x][y] != 0 && map[x][y] < sharkSize) {
                if (dist < minDistance) {
                    nFood = new int[]{x, y, dist};
                    minDistance = dist;
                }
                if (dist == minDistance) {
                    if (x < nFood[0] || (x == nFood[0] && y < nFood[1])) {
                        nFood = new int[]{x, y, dist};
                    }
                }
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
        return nFood;
    }
}