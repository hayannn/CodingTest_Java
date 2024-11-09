import java.util.*;

/*알고리즘
1. OR 연산으로 arr1, arr2를 합치고, 두 지도 중 하나라도 벽 즉, 1인 곳은 결과 지도에서 벽으로 표시하기
2. OR 연산 결과를 이진수로 변환하기
- 문자열 길이 < n -> 앞에 0을 채워서 n의 자릿수 맞추기
3. 1을 #으로, 0을 ' '으로 변환하기
4. 배열로 최종 지도값 반환
*/

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String binaryString = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
            
            result[i] = binaryString.replace('1', '#').replace('0', ' ');
        }

        return result;
    }
}