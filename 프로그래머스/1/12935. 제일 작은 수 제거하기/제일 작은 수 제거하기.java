import java.util.*;

/* 알고리즘
- 배열 길이 체크
  - arr.length == 1이면 [-1] 반환 후 바로 종료
- 최솟값 찾기
  - 배열의 최솟값을 찾고, 최솟값 제외하고 배열을 생성
    - 최솟값이 아닌 원소만 필터링 및 새 배열 생성
*/

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{
                -1
                };
        }

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}