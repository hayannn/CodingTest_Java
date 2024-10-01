import java.util.*;

/* 알고리즘
- weights 오름차순 정렬
- map을 이용해 weights를 순회
    - 맵에 a가 있다면 -> 가져오기 (중복체크)
    - 맵에 b가 있다면 -> 가져오기 (중복체크)
    - 맵에 c가 있다면 -> 가져오기 (중복체크)
    - 맵에 d가 있다면 -> 가져오기 (중복체크)
*/

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i : weights){
            double a = i * 1.0;
            double b = (i * 2.0) / 3.0;
            double c = (i * 1.0) / 2.0;
            double d = (i * 3.0) / 4.0;
            
            if(map.containsKey(a)){
                answer += map.get(a);
            }
            
            if(map.containsKey(b)){
                answer += map.get(b);
            }
            
            if(map.containsKey(c)){
                answer += map.get(c);
            }
            
            if(map.containsKey(d)){
                answer += map.get(d);
            }
            
            map.put((i * 1.0), map.getOrDefault((i * 1.0), 0)+1);
            
            
        }
        return answer;
    }
}