import java.util.*;

/*알고리즘
- 값이 4개 이상 들어왔을 경우
    - 값이 1, 2, 3, 1의 순서로 들어왔다면 -> answer ++
*/
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> hamburger = new ArrayList<>();
        
        for (int i = 0; i < ingredient.length; i++) {
            hamburger.add(ingredient[i]);

            if (isHamburger(hamburger)) {
                answer++;
                
                for(int j=0; j<4; j++){
                    hamburger.remove(hamburger.size()-1);
                }
            }
        }
        return answer;
    }
    
    public boolean isHamburger(ArrayList<Integer> hamburger) {
        int size = hamburger.size();
        
        return size >= 4 && hamburger.get(size - 4) == 1 && hamburger.get(size - 3) == 2 && hamburger.get(size - 2) == 3 && hamburger.get(size - 1) == 1;
    }
}