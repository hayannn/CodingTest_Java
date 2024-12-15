/* 알고리즘
- 각 노드의 방문 여부를 확인하는 배열 생성
- DFS -> 현재 노드와 연결된 모든 노드 방문
  - 1번의 DFS마다 네트워크 개수가 1씩 증가
*/

class Solution {
    public int solution(int n, int[][] computers) {
        int networkCount = 0;
        boolean[] visitedNodes = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visitedNodes[i]) {
                networkCount++;
                exploreNetwork(i, visitedNodes, computers);
            }
        }
        
        return networkCount;
    }
    
    private void exploreNetwork(int currentNode, boolean[] visitedNodes, int[][] computers) {
        visitedNodes[currentNode] = true;
        
        for (int nextNode = 0; nextNode < computers.length; nextNode++) {
            if (!visitedNodes[nextNode] && computers[currentNode][nextNode] == 1) {
                exploreNetwork(nextNode, visitedNodes, computers);
            }
        }
    }
}