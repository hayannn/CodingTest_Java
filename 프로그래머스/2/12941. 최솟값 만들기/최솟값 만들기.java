import java.util.*;

/* 알고리즘
- 배열 A, B : 오름차순 정렬
- A는 오름차순, B는 내림차순(역순)으로 곱셈 조합 만들기
- 모든 곱의 합을 계산
*/

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - i - 1];
        }
        return answer;
    }
}