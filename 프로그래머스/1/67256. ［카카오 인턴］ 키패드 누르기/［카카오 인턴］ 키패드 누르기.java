/* 알고리즘
- 왼손은 * (10), 오른손은 # (12)
- 1, 4, 7
  - L을 기록하고 왼손 위치를 업데이트
- 3, 6, 9
  - R을 기록하고 오른손 위치를 업데이트
- 2, 5, 8, 0
  - 거리 계산 필요
    - {(현재 번호 - 타겟 번호) / 3} + {(현재 번호 + 타겟 번호) % 3}
*/

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int left = 10, right = 12; // * = 10, # = 12
        
        for (int num : numbers) {
            if (num == 0) {
                num = 11;
            }
            
            if (num % 3 == 1) {
                left = num;
                answer.append("L");
                continue;
            }
            
            if (num % 3 == 0) {
                right = num;
                answer.append("R");
                continue;
            }
            
            int leftDist = getDistance(left, num);
            int rightDist = getDistance(right, num);
            
            if (leftDist < rightDist || (leftDist == rightDist && hand.equals("left"))) {
                left = num;
                answer.append("L");
                continue;
            }
            
            right = num;
            answer.append("R");
        }
        return answer.toString();
    }

    public int getDistance(int start, int target) {
        return Math.abs(start - target) / 3 + Math.abs(start - target) % 3;
    }
}