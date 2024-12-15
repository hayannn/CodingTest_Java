/* 알고리즘
- targetCount: n비트에서 1 개수를 구하기
- 증가된 n비트에서 1 개수 다시 계산
- 1 개수가 원래 숫자 n 비트에서 1 개수와 같다 -> 다음 큰 숫자로 반환됨
*/

class Solution {
    public int solution(int n) {
        int targetCount = Integer.bitCount(n);

        while (Integer.bitCount(++n) != targetCount) {
        }

        return n;
    }
}