import java.util.*;

/* 알고리즘
- HashMap으로 구현
    - put을 이용해 각 성격 유형을 모두 넣어주기(8가지)
    - 만약 choices[i]가 4보다 작은 경우
        - 첫 번째 문자가 survey[i]에서 선택
        - 점수를 4 - choices[i]만큼 증가
    - 만약 choices[i]가 4보다 큰 경우
        - 두 번째 문자가 survey[i]에서 선택
        - 점수를 choices[i] - 4 만큼 증가
    - 정답 결과 get하기
        - R, C, J, A를 type1으로 하고, T, F, M, N을 type2로 지정
        - 만약, type1 > type2라면 -> answer에 type1 넣기
        - 그렇지 않다면 -> answer에 type2 넣기
*/


class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + choices[i] - 4);
            }
        }
        
        char[] typeOne = {'R', 'C', 'J', 'A'};
        char[] typeTwo = {'T', 'F', 'M', 'N'};

        for (int i = 0; i < typeOne.length; i++) {
            if (map.get(typeOne[i]) >= map.get(typeTwo[i])) {
                answer += typeOne[i];
            } else {
                answer += typeTwo[i];
            }
        }
        return answer;
    }
}