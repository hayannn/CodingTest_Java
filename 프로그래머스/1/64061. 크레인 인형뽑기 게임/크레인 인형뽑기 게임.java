import java.util.*;

/*알고리즘
- 인형이 있으면 -> 해당 칸은 0으로 설정하기
- 스택 사용
  - 같은 인형이면 제거하고, 터트린 인형 개수를 증가
  - 인형이 바구니 맨 위와 다를 경우에도 -> 인형을 바구니에 넣기
*/

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            move -= 1;

            for (int i = 0; i < board.length; i++) {
                int doll = board[i][move];

                if (doll != 0) {
                    board[i][move] = 0;

                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}