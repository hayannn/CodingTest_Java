import java.util.*;

/*알고리즘
- cards1과 cards2에 적힌 단어들로 조합
    - goal를 만들 수 있다면 -> "Yes"
    - 만들 수 없다면 -> "No"
*/

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        int card1Index = 0;
        int card2Index = 0;
        
        for(int i=0; i<goal.length; i++){
            if(card1Index < cards1.length && goal[i].equals(cards1[card1Index])){
                card1Index++;
                answer = "Yes";
                continue;
            }

            if(card2Index < cards2.length && goal[i].equals(cards2[card2Index])){
                card2Index++;
                answer = "Yes";
                continue;
            }
            
            else {
                answer = "No";
                return answer;
            }
            
        }
        return answer;
    }
}