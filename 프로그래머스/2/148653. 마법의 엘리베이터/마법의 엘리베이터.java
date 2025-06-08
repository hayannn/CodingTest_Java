/* 알고리즘
- 각 자리의 수를 오른쪽부터 확인
- 현재 자리 수가 5보다 크면
    - 10 - digit 만큼 위로 올라가고 -> 다음 자리수에 +1 해주기
- 현재 자리 수가 5이고 다음 자리 수가 5 이상이면
    - +1 해주기
- 위의 모든 경우가 아니라면
    - 그냥 해당 자리 수만큼 버튼 누르기
- storey가 0이 될 때까지 반복
*/

class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int digit = storey % 10;
            int next = (storey / 10) % 10;

            boolean roundUp = (digit > 5) || (digit == 5 && next >= 5);
            answer += roundUp ? 10 - digit : digit;
            if (roundUp) {
                storey += 10 - digit;
            }

            storey /= 10;
        }

        return answer;
    }
}