import java.util.*;

/*알고리즘
- 0부터 9까지 모두 더한 숫자 = 45이니, 여기에서 numbers를 빼면 됨.
*/

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int i : numbers) {
            answer -= i;
        }
        return answer;
    }
}