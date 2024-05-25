//알고리즘 출처 : https://psip31.tistory.com/169

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){ //s가 1이 될때까지 반복
            char[] charArr = s.toCharArray();
            
            for(int i=0; i<charArr.length; i++){
                //1이면 무시
                if("1".equals(String.valueOf(charArr[i]))) continue;
                //0이면 증가
                else answer[1]++;
            }
            
            //toBinaryString으로 이진수 변환 전, 그 전의 0을 없애고 그 길이를 이진수로 변환
            s = Integer.toBinaryString(s.replaceAll("0","").length());
            
            //이진 변환 횟수+1
            answer[0]++;
        }
        return answer;
    }
}