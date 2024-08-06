import java.util.*;

/*알고리즘
1. 앞부분 배열과 뒷부분 배열을 나누어 for문 작성
2. 앞부분 배열 : 1~food.length-1까지 증가 + '0' 추가
3. 뒷부분 배열 : 거꾸로 정렬되어야 하기 때문에 food.length-1 ~ 1까지 감소
4. answer : 0을 붙인 앞부분 배열 + 뒷부분 배열로 출력
*/

class Solution {
    public String solution(int[] food) {
        
        //Arrays.sort(food);
        
        String first = "";
        String second = "";
        //int mid = food.length / 2;
        
        
        // 앞부분
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                first += i;
            }
        }
        first += '0';
        
        //뒷부분
        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                second += i;
            }
        }

        String answer = first + second;
        return answer;
    }
}