/*
알고리즘
- 외벽의 길이 n의 범위 내에서
  - dist 배열에 있는 이동거리를 내림차순 정렬(큰 수부터)
  - 큰 수부터 각각 weak 배열에 있는 취약 지점 외벽 점검을 진행하기
    - 점검 가능한 외벽 확인(순회)
    - 점검 불가능한 경우 -1 리턴
- 별도 메서드 : 현재 시작 지점에서 외벽을 점검가능 여부 체크, 점검한 취약 지점 개수 세기
*/

/*
알고리즘2
출처 : https://sc-science.tistory.com/93
원형 배열의 시작점을 하나씩 바꿔가면서, 친구dist의 순열을 구하여
각 경우마다 최소 필요한 친구 수를 구하기

어떤 경우에도 취약점을 모두 점검할 수 없다면 return -1
모든 취약점을 점검하는데 필요한 최소 친구 수를 구하기
*/

//오후 10시 15분 ~ 10시 51분
//오답 풀이 ~ 11시 20분
import java.util.*;

class Solution {
    static public int[] weakList;
    static public int answer;
    public int solution(int n, int[] weak, int[] dist) {

        answer = Integer.MAX_VALUE;
        weakList = new int[weak.length*2];
        int i=0;
        while (i<weak.length){
            weakList[i] = weak[i];
            weakList[i + weak.length] = weak[i++]+n;
        }

        for(int k=0; k<weak.length; k++) {// 시작점 옮기기
            dfs(k, 0, dist, new boolean[dist.length], new int[dist.length]);
        }

        if(answer==Integer.MAX_VALUE) return -1;

        return answer;
    }

    public void dfs(int start, int depth, int[] dist, boolean[] visited, int[] permuted) {
        //permuted -> dist의 순열을 나타냄.
        if(depth==dist.length) {
            answer = Math.min(answer, check(start, start+weakList.length/2, permuted));
            return;
        }
        for(int i=0; i<dist.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            permuted[depth] = dist[i];
            dfs(start, depth+1, dist, visited, permuted);
            visited[i] = false;
        }
    }

    public int check(int start, int end, int[] permuted) {
        int friend = 1;// permuted의 index
        int pos = weakList[start]+permuted[friend-1];// 시작점 : 첫 취약점의 위치+친구거리

        for(int i=start; i<end; i++) {
            if(pos < weakList[i]) {// 점검 위치 벗어나면
                friend++; // 친구추가
                if (friend > permuted.length) return Integer.MAX_VALUE;
                pos = weakList[i] + permuted[friend-1];
            }
        }
        return friend;
    }
}