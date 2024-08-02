import java.util.*;

/*알고리즘
1. 이동 방향(N, S, W, E) HashMap으로 설정
2. routes 순회
    - 경로 이동 시도
    - 공원 경계 벗어나거나, 장애물 X에 닿으면 종료
3. 최종 위치 반환
4. 별도 메서드 : 시작 위치를 찾는 메서드 구현(answer 배열에 넣을 것)
*/

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        //getAnswer 적용해야 할 듯..?
        //int[] answer = {};
        int[] answer = getAnswer(park);
        
        Map<Character, int[]> coord = new HashMap<>();

        coord.put('N', new int[]{-1, 0});
        coord.put('S', new int[]{1, 0});
        coord.put('W', new int[]{0, -1});
        coord.put('E', new int[]{0, 1});
        
        for(String route : routes){
            char direction = route.charAt(0);
            int count = route.charAt(2) - '0';
            
            int[] directionXY = coord.get(direction);
            
            //위치
            int dx = directionXY[0];
            int dy = directionXY[1];
            
            
            //현재 위치
            int cx = answer[0];
            int cy = answer[1];
            
            boolean visited = true;
            
            for(int i=0; i<count; i++){
                cx += dx;
                cy += dy;
                
                //공원 경계 벗어나거나, 장애물 X에 닿으면 종료
                if(cx < 0 || cy < 0 || cx >park.length-1 || cy >park[0].length()-1){
                    visited = false;
                    break;
                }
                
                if( park[cx].charAt(cy) == 'X'){
                    visited = false;
                    break;
                }
            }
                
            if(visited){
                answer[0] = cx;
                answer[1] = cy;
            }   
        }
        return answer;
    }
    
    //별도 메서드 : 시작 위치를 찾는 메서드 구현(answer 배열에 넣을 것)
    public int[] getAnswer(String[] park){
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                char current = park[i].charAt(j);
                
                if('S' == current){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0,0};
    }
}