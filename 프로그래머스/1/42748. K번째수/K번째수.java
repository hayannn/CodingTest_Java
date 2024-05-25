import java.util.*;
/*
[알고리즘]
1. 배열 자르기(자른 배열 copy해서 저장)
2. 자른 배열 정렬하기
3. K번째에 있는 수 구하기
* 참고 : commands의 형태 -> [i,j,k], [i,j,k], [i,j,k]
*/

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        //int[] answer = {};
        
        
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            //1. 배열 자르기(자른 배열 copy해서 저장)
            int[] cut = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); //주의: commands[i][0]은 인덱스 1의 위치이므로 -1을 해줘야 0부터 시작함!
            
            //2. 자른 배열 정렬하기
            Arrays.sort(cut);
            
            //3. K번째에 있는 수 구하기
            answer[i] = cut[commands[i][2]-1]; //위의 주의와 같은 이유
        }
        return answer;
    }
}