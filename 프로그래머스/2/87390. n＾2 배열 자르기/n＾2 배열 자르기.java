/*알고리즘
- n x n 배열에서 (i, j) 위치의 값은 max(i, j) + 1임
- left부터 right까지 1차원 배열로 변환된 인덱스를 활용해 직접 값 계산
*/

public class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            long index = left + i;
            int row = (int) (index / n);
            int col = (int) (index % n);
            answer[i] = Math.max(row, col) + 1;
        }

        return answer;
    }
}