import java.util.*;

class Solution {
    public long solution(long n) {
        //숫자를 문자열로 변환
        String numStr = Long.toString(n);
        
        //문자열을 문자 배열로 변환 후 정렬
        Character[] charArr = new Character[numStr.length()];
        for(int i=0; i<numStr.length(); i++){
            charArr[i] = numStr.charAt(i);
        }
        
        Arrays.sort(charArr, Collections.reverseOrder());
        
        
        //역순 출력해 문자열로 변환
        StringBuilder sortStr = new StringBuilder();
        for(char c : charArr){
            sortStr.append(c);
        }
        long answer = Long.parseLong(sortStr.toString());
        return answer;
    }
}