import java.util.*;

/*알고리즘
- first, second로 나누기(형 조각, 동생 조각)
  - first : 토핑 종류를 HashSet으로 저장
  - second : 남은 토핑 개수를 HashMap으로 저장 -> 하나씩 제거
- first와 second의 크기가 같아질 때마다 카운트++
*/

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;
        
        Set<Integer> first = new HashSet<>();
        Map<Integer, Integer> second = new HashMap<>();
        
        for (int i = 1; i < size; i++) {
            second.put(topping[i], second.getOrDefault(topping[i], 0) + 1);
        }
        
        first.add(topping[0]);
        
        for (int i = 1; i < size; i++) {
            first.add(topping[i]);
            second.put(topping[i], second.get(topping[i]) - 1);
            if (second.get(topping[i]) == 0) {
                second.remove(topping[i]);
            }
            if (first.size() == second.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}
