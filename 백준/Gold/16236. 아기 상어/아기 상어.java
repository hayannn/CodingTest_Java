import java.util.*;

class Node implements Comparable<Node> {
    int x, y, distance;

    Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance == other.distance) {
            if (this.x == other.x)
                return Integer.compare(this.y, other.y);
            return Integer.compare(this.x, other.x);
        }
        return Integer.compare(this.distance, other.distance);
    }
}

public class Main {
    static int[][] map;
    static int size = 2;
    static int eat = 0;
    static int result = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N;
    static int startX;
    static int startY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        startX = 0;
        startY = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Node target = find(startX, startY);
            if (target == null) break;
            startX = target.x;
            startY = target.y;
            result += target.distance;
            eat++;
            if (eat == size) {
                size++;
                eat = 0;
            }
            map[startX][startY] = 0;
        }
        System.out.println(result);
    }

    static Node find(int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        pq.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (map[now.x][now.y] != 0 && map[now.x][now.y] < size) {
                return now;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] <= size) {
                    visited[nx][ny] = true;
                    pq.offer(new Node(nx, ny, now.distance + 1));
                }
            }
        }
        return null;
    }
}