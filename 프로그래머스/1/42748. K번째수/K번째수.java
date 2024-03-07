//오전 10시 6분 ~ 오전 10시 42분

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        //commands : [[i, j, k], [i, j, k], [i, j, k]] 형식
        
        /*
        1. 배열 자르기
        2. 자른 배열 정렬하기
        3. k에 해당하는 k번째 숫자 리턴하기(배열에 담아서 리턴해야 함)
        */
        
        int[] result = new int[commands.length];
        
        for(int i = 0; i<commands.length; i++){
            int[] command = commands[i]; //자르기 시작하는 부분만 확인할 수 있도록 command 추가
                
            //1. 배열 자르기
            int[] cut = Arrays.copyOfRange(array, command[0] - 1, command[1]); //인텍스가 0부터 시작되는데, 프로그램에서는 1부터 인식하기 때문

            //2. 자른 배열 정렬하기
            Arrays.sort(cut);

            //3. k에 해당하는 k번째 숫자 리턴하기(배열에 담아서 리턴해야 함)
            result[i] = cut[command[2] - 1];
        }
        return result;   
    }
}

