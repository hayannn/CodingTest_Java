import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;

    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static ArrayList<int[]> union;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        sc.nextLine();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(move());
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        union = new ArrayList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int sum = arr[x][y];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];

            union.add(current);

           for (int i = 0; i < 4; i++) {
              int nx = x + dx[i];
              int ny = y + dy[i];
              if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                 int population = Math.abs(arr[x][y] - arr[nx][ny]);

                 if (L <= population && population <= R) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sum += arr[nx][ny];
                 }
              }
           }
        }
        return sum;
    }

    public static int move() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (union.size() > 1) {
                            change(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) return result;
            result++;
        }
    }

    public static void change(int sum) {
        int average = sum / union.size();
        for (int[] coord : union) {
            arr[coord[0]][coord[1]] = average;
        }
    }
}