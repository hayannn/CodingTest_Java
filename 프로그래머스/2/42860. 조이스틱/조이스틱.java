/* 알고리즘
1. answer(조작 횟수) 변수 선언하기
2. 값 확인 및 이동 횟수 변수 선언하기
3. 상하로 움직이는 경우 계산하기
    - Math.min(알파벳2 - 알파벳1 , 26 - (알파벳2 - 알파벳1))
4. 좌우로 움직이는 경우 계산하기
    - 오른쪽으로 갔다 다시 왼쪽으로 꺾기
      - move = Math.min(원래 이동 횟수, 뒤로 돌아가 계산하는 횟수)
    - 왼쪽으로 갔다 다시 오른쪽으로 꺾기
      - move = Math.min(move, 뒤로 돌아가 계산하는 횟수)
*/

import java.util.*;

class Solution {
    public int solution(String name) {
        
    // 1. answer(조작 횟수) 변수 선언하기
    int answer = 0;
    
    // 2. 값 확인 및 이동 횟수 변수 선언하기
    int index;
    int move = name.length() - 1; // 오른쪽을 기준으로 계속 오른쪽으로 이동하는 횟수
    
    /* 3. 상하로 움직이는 경우 계산하기
    - Math.min(알파벳2 - 알파벳1 , 26 - (알파벳2 - 알파벳1)) */
    for(int i=0; i<name.length(); i++){
        answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
        
        index = i + 1; //다음 위치
        while(index < name.length() && name.charAt(index) == 'A'){
            index++;
        }
        
        // 4. 좌우로 움직이는 경우 계산하기
        /* - 오른쪽으로 갔다 다시 왼쪽으로 꺾기
             - move = Math.min(원래 이동 횟수, 뒤로 돌아가 계산하는 횟수) */
        move = Math.min(move, i*2 + (name.length() - index));
        
        /* - 왼쪽으로 갔다 다시 오른쪽으로 꺾기
             - move = Math.min(move, 뒤로 돌아가 계산하는 횟수) */
        move = Math.min(move, (name.length() - index) * 2 + i);
    }
        return answer + move; //answer는 상하, move는 좌우에 해당하므로 두 값 더하기
    }
}