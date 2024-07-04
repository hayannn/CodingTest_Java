/*알고리즘
1. phone_book 배열 정렬하기
2. 주어진 배열 phone_book의 원소를 각각 비교하여 완전히 겹치는 경우가 있다면 -> true
- 두 원소 비교 시 startsWith를 사용
*/

import java.util.*;


class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return answer;
    }
}