import java.util.*;

/* 알고리즘
- n개 숫자의 합이 s가 되도록 균등 분배
    - 각 원소에 s/n을 할당
    - 나머지(s % n) 만큼 추가 배분
- 오름차순 정렬
    - 작은 값들을 유지 -> 배열 끝에서부터 1씩 추가
*/
class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int base = s / n;
        int mod = s % n;

        int[] answer = new int[n];
        Arrays.fill(answer, base);

        for (int i = n - mod; i < n; i++) {
            answer[i]++;
        }

        return answer;
    }
}