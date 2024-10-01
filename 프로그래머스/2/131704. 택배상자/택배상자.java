import java.util.*;

/* 알고리즘
- i = 1부터 n까지의 상자를 스택에 넣기
    - 스택 최상단 값이 order[index]와 같으면 pop + 처리된 상자 수를 증가
    - 같지 않으면 더 이상 스택에서 꺼내지 않고 다음 상자를 스택에 넣기
*/

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int index = 0;
        
        Stack<Integer> belt = new Stack<>();
        
        for(int i=1;i<=order.length;i++){
            belt.push(i);
            
            while(!belt.isEmpty()){
                if(belt.peek()==order[index]){
                    belt.pop();
                    index++;
                    answer++;
                }
                else {
                    break;
                }
            }
        }
        return answer;
    }
}