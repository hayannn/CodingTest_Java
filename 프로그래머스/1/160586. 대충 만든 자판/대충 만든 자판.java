import java.util.*;

/*알고리즘
- map을 이용해 key 값을 찾는 방식으로 풀이
- keymap : 현재 값이 기본적으로 key, i+1과 비교해 찾는 key가 나오는 경우 교체
- target : key가 존재한다면 저장, 그렇지 않다면 -1 반환
*/

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        //1. keymap
        for(int i=0; i<keymap.length; i++){
            String keys = keymap[i];
            
            for(int j=0; j<keymap[i].length(); j++){
                char key = keymap[i].charAt(j);
                int value = map.getOrDefault(key, j+1);

                map.put(key, Math.min(value, j+1));
            }
        }
        
        //2. targets
        for(int i=0; i<targets.length; i++){
            for(int j=0; j<targets[i].length(); j++){
                char key = targets[i].charAt(j);
                
                if(map.containsKey(key)){
                    answer[i] += map.get(key);
                }
                else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}