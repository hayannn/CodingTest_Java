/* 알고리즘

- 원형 배열 -> 배열을 2배로 확장해서 연속 처리하듯이 배열
- 길이 1 ~ 배열 전체 길이까지의 모든 연속 부분 수열 합 구하기
- 중복 없이 set에 넣어서 개수 반환하기

*/

import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int len = elements.length;
        int[] extended = new int[len * 2];
        for (int i = 0; i < len * 2; i++) {
            extended[i] = elements[i % len];
        }

        // 모든 길이의 연속 부분 수열 합 계산
        for (int size = 1; size <= len; size++) {
            for (int start = 0; start < len; start++) {
                int sum = 0;
                for (int i = start; i < start + size; i++) {
                    sum += extended[i];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}