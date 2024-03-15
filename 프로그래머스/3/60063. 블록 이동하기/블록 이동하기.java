//알고리즘 출처 : https://thdbs523.tistory.com/263

import java.util.*;

class Solution {
    
    static int[][] nowBoard;
    static int result= 0;
    static boolean[][][] visited;
    static int N;
    
    // 상하좌우 이동
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    // 가로 -> 세로 회전 (↖ ↙ ↗ ↘ 순서)
    static int[][] hTurn = {{-1, 0}, {0, 0}, {-1, 1}, {0, 1}};
    
    //벽 확인
    static int[][] hBlock = {{-1, 1}, {1, 1}, {-1, 0}, {1, 0}};
    
    // 세로 -> 가로 회전 (↖ ↙ ↗ ↘ 순서)
    static int[][] wTurn = {{0, -1}, {1, -1}, {0, 0}, {1, 0}};
    
    //벽 확인
    static int[][] wBlock = {{1, -1}, {0, -1}, {1, 1}, {0, 1}};

    public int solution(int[][] board) {
        nowBoard = board;
        N = board.length;

        // 가로 = 0, 세로 = 1
        visited = new boolean[2][N][N];

        bfs();
        return result;
    }

    static void bfs() {
        Queue<Robot> queue = new LinkedList<>();

        queue.offer(new Robot(0, 0, 0, 0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Robot now = queue.poll();

            if((now.d == 0 && now.x == N - 1 && now.y + 1 == N - 1) || (now.d == 1 && now.x + 1 == N - 1 && now.y == N - 1)) {
                result = now.time;
                break;
            }

            // 상하좌우로 확인
            for(int i=0;i<4;i++) {
                int nX = now.x + move[i][0];
                int nY = now.y + move[i][1];

                if(check(nX, nY, now.d)) {
                    visited[now.d][nX][nY] = true;
                    queue.offer(new Robot(nX, nY, now.d, now.time + 1));
                }
            }
            
            //1. 가로 -> 세로로 회전
            if(now.d == 0) {
                for(int i=0;i<4;i++) {
                    int nX = now.x + hTurn[i][0];
                    int nY = now.y + hTurn[i][1];
                    int nD = 1;

                    if(check(nX, nY, nD) && nowBoard[now.x + hBlock[i][0]][now.y + hBlock[i][1]] == 0) {
                        visited[nD][nX][nY] = true;
                        queue.offer(new Robot(nX, nY, nD, now.time + 1));
                    }
                }
            }
            
            //2. 세로 -> 가로로 회전
            else {
                for(int i=0;i<4;i++) {
                    int nX = now.x + wTurn[i][0];
                    int nY = now.y + wTurn[i][1];
                    int nD = 0;

                    if(check(nX, nY, nD) && nowBoard[now.x + wBlock[i][0]][now.y + wBlock[i][1]] == 0) {
                        visited[nD][nX][nY] = true;
                        queue.offer(new Robot(nX, nY, nD, now.time + 1));
                    }
                }
            }
        }
    }

    static boolean check(int x, int y, int d) {
        
        // 범위 밖
        if(x<0 || y<0 || x>=N || y>=N || visited[d][x][y] || nowBoard[x][y] == 1){
            return false;
        }

        if(d == 0 && (y+1 >= N || nowBoard[x][y + 1] == 1)) {
            return false;
        }

        if(d == 1 && (x + 1 >= N || nowBoard[x + 1][y] == 1)) {
            return false;
        }

        return true;
    }
    
        static class Robot {
        int x, y, d, time;

        Robot(int x, int y, int d, int time) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.time = time;
        }
    }
}
