/*알고리즘
0. 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 resurve 입력받기(내부에서 진행)
1. lost, reserve 배열 정렬
2. 전체 학생 n - lost -> 체육복(여벌 X)을 가진 학생 수 도출
3. lost && reserve (lost==reserve)-> 체육복 O, 빌려줄 수 X
    - answer 증가
4. 그게 아닐 경우 -> 체육복을 앞과 뒤 번호 학생에게 빌려줄 수 O
    - lost[i] - 1과 현재 학생이 같거나, lost[i] + 1과 현재 학생이 같은 경우
*/

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        
        //다른 학생에게 체육복을 빌려줄 수 없는 경우 -> 여벌 체육복 O, 도난 O
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        //도난 O -> 체육복을 빌릴 수 있는 학생 수
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    answer++;
                    //lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}