import java.util.*;

/* 알고리즘 
1. terms 배열 반복 -> termMap에 저장
2. today를 .를 기준으로 파싱 -> 정수형으로 연, 월, 일 분리 저장
3. privacies 배열로 날짜 파싱 -> 월이 12를 넘어가면 연도 증가하기
4. 만료일 < 오늘날짜 라면 -> answer에 추가(단, 인덱스는 1부터)
*/

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        int mDays = 28;
        int totalToday = getTotalDays(today, mDays);
        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            termMap.put(term.charAt(0), Integer.parseInt(term.substring(2)));
        }

        for (int i = 0; i < privacies.length; i++) {
            char pO = privacies[i].charAt(11);
            int totalPrivacy = getTotalDays(privacies[i].substring(0, 10), mDays) +
                               termMap.get(pO) * mDays;
            if (totalPrivacy <= totalToday) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public int getTotalDays(String date, int mDays) {
        String[] parts = date.split("\\.");
        return (Integer.parseInt(parts[0]) * mDays * 12) +
               (Integer.parseInt(parts[1]) * mDays) +
               Integer.parseInt(parts[2]);
    }
}
