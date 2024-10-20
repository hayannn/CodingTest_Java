import java.util.*;

/*알고리즘
1. 배열 오름차순 정렬
2. 만약 arr[i] % divisor == 0 이면 -> 카운드 증가하기
    - 그렇지 않다면 -> -1 반환
*/

class Solution {
    public int[] solution(int[] arr, int divisor) {
        Arrays.sort(arr);
        
        List<Integer> resultList = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                resultList.add(arr[i]);
            }
        }
        
        if (resultList.isEmpty()) {
            return new int[] {-1};
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}