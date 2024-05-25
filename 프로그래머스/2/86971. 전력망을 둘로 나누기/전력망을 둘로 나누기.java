/*알고리즘
- bfs 활용해서 풀이하기
-> wires.length만큼 반복해서 bfs 돌려주기
돌릴 때마다 트리 구조를 나타내는 2차원 리스트를 초기화 해주는데,
여기서 현재 제외할(끊을 선) idx의 wires는 제외하고 초기화 해준다.
그리고 나서 임의로 정점 0번을 넣어 bfs를 돌린 후,
방문한 곳과 방문하지 않은 곳으로 나뉘게 되는데 카운트 해줘서 계산해주면 된다.
출처 : https://velog.io/@anytime0916/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%84%EB%A0%A5%EB%A7%9D-%EB%91%98%EB%A1%9C-%EB%82%98%EB%88%84%EA%B8%B0-JAVA
*/

import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++){
            bfs(n, i, wires);
        }
        return answer;
    }
    
    //bfs 메서드
    public static void bfs(int n, int index, int[][] wires){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n];
        
        q.offer(0);
        visited[0] = true;
        int count = 1; //시작 정점은 이미 방문했으니 1로 시작
        
        while(!q.isEmpty()){
            int x = q.poll();
            
             for(int i = 0; i< wires.length; i++){
                if(wires[i] == wires[index]) continue;
                
                int a = wires[i][0];
                int b = wires[i][1];
                
                if(a - 1 == x && !visited[b - 1]){
                    visited[b - 1] = true;
                    q.offer(b - 1);
                    count++; // 새로운 정점을 방문했으므로 카운트 증가
                }
                
                if(b - 1 == x && !visited[a - 1]){
                    visited[a - 1] = true;
                    q.offer(a - 1);
                    count++; // 새로운 정점을 방문했으므로 카운트 증가
                }
            }
        }
        
        answer = Math.min(answer, Math.abs(n-2*count));  
    }
}