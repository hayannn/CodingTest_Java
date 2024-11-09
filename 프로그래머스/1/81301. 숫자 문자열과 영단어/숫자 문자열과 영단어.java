import java.util.*;

/*알고리즘
- 영어 숫자 단어 배열 지정
- replace로 숫자 교체
*/

class Solution {
    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < arr.length; i++) {
            s = s.replace(arr[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}