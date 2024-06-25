/*알고리즘
0. people 정렬하기 + 가장 가벼운 사람 lightest 선언하기
1. for문
- i가 people.length-1부터 시작해야 함.(정렬 후에 가장 마지막 요소가 n-1이기 때문)
- 또한, 역순으로 파악하기 위해 가장 가벼운 사람 lightest보다 i가 크거나 같은 경우, i--를 통해 구해야 함.
  - 2명의 무게 합이 limit 이하인 경우 -> lightest++ 계속 증가
2. for문으로 빠져나와 최종 최소값인 answer에 증가해주기 -> 정답
*/

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int lightest = 0; // 가장 가벼운 사람 선언
        
        Arrays.sort(people);
        
        for(int i=people.length-1; i >= lightest; i--){
            if(people[lightest] + people[i] <= limit) {
                lightest++;
            }
            answer++;
        }
        
        return answer;
    }
}