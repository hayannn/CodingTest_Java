import java.util.*;

/* 알고리즘
- LRU 캐시
  - 캐시 히트(캐시에 있음) -> 기존 데이터 삭제 후 최신 위치로 갱신 -> 실행 시간 +1
  - 캐시 미스(캐시에 없음)
    - 캐시가 가득 차면 가장 오래된 데이터 삭제
    - 새 데이터를 추가 -> 실행 시간 +5
*/

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        int answer = 0;
        LinkedHashSet<String> cache = new LinkedHashSet<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)) {
                cache.remove(city);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    Iterator<String> it = cache.iterator();
                    it.next();
                    it.remove();
                }
                answer += 5;
            }
            cache.add(city);
        }

        return answer;
    }
}