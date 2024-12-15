import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int maxBishops;
    static int maxBlackBishops;
    static int maxWhiteBishops;

    static int[][] board;
    static int[][] colorPattern;
    static boolean[][] occupied;
    static int[][] directions = {{-1,-1},{-1,1},{1,-1},{1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        occupied = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        colorPattern = new int[N][N];
        initializeColorPattern();

        backtrack(0, 0, 0, 0);
        backtrack(0, 1, 1, 0);

        maxBishops = maxBlackBishops + maxWhiteBishops;
        System.out.println(maxBishops);
    }

    static void initializeColorPattern() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                colorPattern[i][j] = (i + j) % 2;
            }
        }
    }

    static void backtrack(int y, int x, int color, int count) {
        if (y >= N) {
            if (color == 0) {
                maxBlackBishops = Math.max(maxBlackBishops, count);
            } else {
                maxWhiteBishops = Math.max(maxWhiteBishops, count);
            }
            return;
        }

        int nextX = x + 2;
        int nextY = y;

        if (nextX >= N) {
            nextY++;
            if (nextY < N) {
                nextX = colorPattern[nextY][0] == color ? 0 : 1;
            }
        }

        if (board[y][x] == 0) {
            backtrack(nextY, nextX, color, count);
            return;
        }

        if (isValidPosition(y, x)) {
            occupied[y][x] = true;
            backtrack(nextY, nextX, color, count + 1);
            occupied[y][x] = false;
        }

        backtrack(nextY, nextX, color, count);
    }

    static boolean isValidPosition(int x, int y) {
        int directionCount = 0;
        for (int dir = 0; dir < 4; dir++) {
            if (canMove(x, y, dir)) directionCount++;
        }
        return directionCount == 4;
    }

    static boolean canMove(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        while (true) {
            nx += directions[dir][0];
            ny += directions[dir][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
            if (occupied[nx][ny]) return false;
        }
        return true;
    }
}