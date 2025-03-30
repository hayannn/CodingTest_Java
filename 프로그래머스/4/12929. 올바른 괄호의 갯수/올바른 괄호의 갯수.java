/* 알고리즘
- DFS
   - 열린 괄호와 닫힌 괄호의 개수를 추적하면서 가능한 모든 괄호 문자열을 탐색
   - 열린 괄호: 최대 n개까지 추가
   - 닫힌 괄호: 열린 괄호보다 더 많을 수 없음
   - 모든 열린 괄호와 닫힌 괄호의 개수가 n -> 올바른 괄호 문자열을 하나 찾은 것
- 재귀 호출
   - 열린 괄호를 추가하고, 닫힌 괄호를 추가할 수 있는 조건을 만족할 때마다 재귀적으로 탐색
   - 괄호 문자열이 완성되면 결과 카운트
*/

class Solution {
    static int answer = 0;

    public int solution(int n) {
        dfs(n, 0, 0);
        return answer;
    }
    
    static public void dfs(int max, int open, int close) {
        if (open == max && close == max) {
            answer++;
            return;
        }
        
        if (open < max) {
            dfs(max, open + 1, close);
        }

        if (close < open) {
            dfs(max, open, close + 1);
        }
    }
}
