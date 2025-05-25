/* 알고리즘
- 문자열을 2글자씩 끊어, 알파벳으로만 된 쌍(bigrams)을 만듦
- 두 문자열에서 나온 bigram 쌍을 다중집합(Multiset)으로 취급
- 두 다중집합의 교집합 크기와 합집합 크기를 구함
- 자카드 유사도 = 교집합/합집합을 구한 뒤 65536을 곱하고 정수로 내림
*/
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Map<String, Integer> map1 = getBigrams(str1);
        Map<String, Integer> map2 = getBigrams(str2);

        if (map1.isEmpty() && map2.isEmpty()) return 65536;

        int inter = 0, union = 0;

        for (String key : map1.keySet()) {
            int count1 = map1.get(key);
            int count2 = map2.getOrDefault(key, 0);
            inter += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                union += map2.get(key);
            }
        }

        return (int) (inter * 65536.0 / union);
    }

    private Map<String, Integer> getBigrams(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String pair = str.substring(i, i + 2);
            if (pair.matches("[A-Z]{2}")) {
                map.put(pair, map.getOrDefault(pair, 0) + 1);
            }
        }
        return map;
    }
}