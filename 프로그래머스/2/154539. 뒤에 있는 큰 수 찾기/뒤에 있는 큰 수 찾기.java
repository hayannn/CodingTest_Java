import java.util.*;

/* 알고리즘
- 인덱스 선언
- 인덱스가 모든 numbers 배열을 순회할 동안
  - 스택이 비어있지 않고 + numbers[stack.peek()] < numbers[i]인 경우 -> numbers[i]를 정답 배열에 저장
  - while문 순회 후 다음 인덱스 값 넣기(push)
  - 더 큰 값을 찾지 못한 경우(while문으로) -> -1 반환
*/

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 스택 사용
        Stack<Integer> stack = new Stack<>();
        
        //1번째
        stack.push(0);
        for(int i=1; i<numbers.length; i++) {
            while(!stack.empty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            //다음 인덱스로 이동
            stack.push(i);
        }
        
        // stack에 남은 인덱스 값들 = -1
        while(!stack.empty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}