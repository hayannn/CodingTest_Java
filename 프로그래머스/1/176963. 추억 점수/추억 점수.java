import java.util.*;

/*알고리즘
- 입력
    - 결과가 저장된 배열 answer 재정의하기
    - 합산할 값 sum 정의하기

- 계산
    - 인물 이름이 중복되는 경우 (equals) -> sum에 yearning 합산

- 출력
    - answer[i]를 sum에 담아 answer 반환
*/


class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        //Arrays.stream(photo).distinct().toArray();
        
        //int sum = 0;
        
        for(int i=0; i < photo.length; i++){
            
            int sum = 0;
            
            for(int j=0; j < photo[i].length; j++){
                for(int k=0; k < name.length; k++){
                    if(photo[i][j].equals(name[k])) {
                        sum += yearning[k];
                        break;
                    }
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}