import java.util.*;

/*알고리즘
- 가격이 떨어질 때까지 stack에 인덱스 저장
- 가격이 떨어지는 순간 -> stack에서 이전 인덱스를 꺼내 현재 인덱스와의 차이 계산
- 끝까지 남아 있는 stack의 요소들은 끝까지 가격이 유지된 경우이니 n - index - 1로 처리
*/

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - idx - 1;
        }
        
        return answer;
    }
}
