import java.util.*;

/*알고리즘
1. babbling[i] 중에서 무시할 발음(2번 이상 연속 발음) continue하기
2. replace 이용
- 허용되는 문자인 "aya", "ye", "woo", "ma"를 발견하면 -> " "로 바꾸기
- 만약 babbling 길이가 0 이면(replace가 끝났다면) -> answer++;
*/

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama") ){
                continue;
            }
            
            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");
            
            if(babbling[i].length() == 0){
                answer++;
            }
        }
        return answer;
    }
}