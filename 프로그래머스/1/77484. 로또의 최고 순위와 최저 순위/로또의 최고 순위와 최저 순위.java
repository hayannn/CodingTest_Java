import java.util.*;

/*알고리즘
- 0의 개수 세기
- lottos, win_nums 비교 -> 숫자 일치하는지 비교
- 최고 순위: 맞춘 개수 + 0의 개수
- 최저 순위: 실제 맞춘 개수
*/

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int zeroCount = 0;
        int matchCount = 0;

        for (int num : lottos) {
            if (num == 0) zeroCount++;
        }

        for (int num : lottos) {
            for (int winNum : win_nums) {
                if (num == winNum) {
                    matchCount++;
                    break;
                }
            }
        }

        answer[0] = rank[matchCount + zeroCount];
        answer[1] = rank[matchCount];

        return answer;
    }
}
