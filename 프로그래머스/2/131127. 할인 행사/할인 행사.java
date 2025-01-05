import java.util.*;

/* 알고리즘
- 슬라이딩 윈도우
  - discount 배열에서 10일 동안의 할인 상품들을 확인
  - i : 할인 기간 시작 인덱스
- 상품 개수 세기
  - 각 10일 기간에 대한 할인된 상품들의 개수를 countMap에 저장
  - countMap은 상품명과 해당 상품이 나온 횟수 기록
- 조건 확인: want 배열에 있는 각 상품이 number[j] 이상인지 확인
- 모든 조건 충족 시 answer 증가
*/

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> countMap = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                countMap.put(discount[j], countMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean isValid = true;
            for (int j = 0; j < want.length; j++) {
                if (countMap.getOrDefault(want[j], 0) < number[j]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) answer++;
        }

        return answer;
    }
}