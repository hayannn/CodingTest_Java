import java.util.*;

/*알고리즘
1. N, M 전역변수 선언
2. Visited, arr, count, dx 및 dy, map 전역변수 선언
3. Solution
  a. N, M, visited, map, arr 초기화
  b. visited와 Map 조건 부여 및 bfs 진행
  c. 최종 결과값 answer는 Math.max를 통해 구하기
4. 별도 메서드 bfs : 큐를 이용해 구현
*/

class Solution {
    
    static int N;
    static int M;
    
    static boolean[][] visited;
    static int[] arr;
    static int count;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    
    static int answer;
    
    public int solution(int[][] land) {
        M = land[0].length;
        N = land.length;
        answer = 0;
        
        map = land;
        
        arr = new int[M];
        visited = new boolean[N][M];
        
        for(int j=0; j<M; j++){
            for(int i=0; i<N; i++){
                if(visited[i][j] || map[i][j] == 0){
                    continue;
                }
                bfs(i, j);
            }
        }
        
        int answer = 0;
        for(int i=0; i<M; i++){
            answer = Math.max(answer, arr[i]);
        }
        
        return answer;
    }
    
    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new LinkedHashSet<>();
        
        
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;
        
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            set.add(current[1]);
            
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == 0 || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                count++;
                q.offer(new int[]{nx, ny});
            }
        }
        for(int current : set){
            arr[current] += count;
        }
        return count;
    }
    
}