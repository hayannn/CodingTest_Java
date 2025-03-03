/* 알고리즘
- 최대 방문 던전 수 갱신
- DFS
  - 현재 남은 피로도로 탐험 가능한 던전을 찾음
  - 방문 체크 후 해당 던전 탐험 (재귀 호출)
  - 탐험 후 방문 초기화 (백트래킹)
*/

class Solution {
    int answer = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}