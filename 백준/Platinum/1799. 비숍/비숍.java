import java.io.*;
import java.util.*;

public class Main {
    static int N, result, black, white;
    static int[][] map, chess;
    static boolean[][] visited;
    static int[][] deltas = {{-1,-1}, {-1,1}, {1,-1}, {1,1}};
    
    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(result);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        chess = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = (i + j) % 2;
            }
        }
    }

    public static void solve() {
        black = 0;
        white = 0;
        dfs(0, 0, chess[0][0], 0);
        dfs(0, 1, chess[0][1], 0);
        result = black + white;
    }

    public static void dfs(int y, int x, int color, int count) {
        if (y >= N) {
            if (color == 0) {
                black = Math.max(black, count);
            } else {
                white = Math.max(white, count);
            }
            return;
        }

        int nx = x + 2;
        int ny = y;

        if (nx >= N) {
            ny++;
            if (ny < N) {
                nx = (chess[ny][0] == color) ? 0 : 1;
            }
        }

        if (map[y][x] == 0) {
            dfs(ny, nx, color, count);
            return;
        }

        if (check(y, x)) {
            visited[y][x] = true;
            dfs(ny, nx, color, count + 1);
            visited[y][x] = false;
        }

        dfs(ny, nx, color, count);
    }

    public static boolean check(int x, int y) {
        int goCnt = 0;
        for (int dir = 0; dir < 4; dir++) {
            if (go(x, y, dir)) goCnt++;
        }
        return goCnt >= 4;
    }

    public static boolean go(int x, int y, int dir) {
        int nx = x, ny = y;
        while (true) {
            nx += deltas[dir][0];
            ny += deltas[dir][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
            if (visited[nx][ny]) return false;
        }
        return true;
    }
}