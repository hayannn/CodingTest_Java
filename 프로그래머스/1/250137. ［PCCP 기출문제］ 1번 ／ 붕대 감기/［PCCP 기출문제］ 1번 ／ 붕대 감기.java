import java.util.*;

class Solution {
    
    static int nowH = 0; //현재 체력
    static int lastAttack = 0; //마지막 공격 시간
    static int nextAttack = 0; //다음 공격
    static int bandageTime = 0; //붕대 감고 있는 시간
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int nowH = health;
        lastAttack = attacks[attacks.length-1][0];
        
        //수정: 현재 시간이 lastAttack까지 포함할 수 있도록 변경
        for(int i=1; i<=lastAttack; i++){
            
            //수정: 현재 시간과 다음 공격 시간이 같다면 -> 몬스터 공격 시간
            if(nextAttack < attacks.length && i == attacks[nextAttack][0]){
                bandageTime = 0; //수정: 초기화 추가
                nowH -= attacks[nextAttack][1];
                
                //수정: -1 출력하는 경우 추가
                if(nowH <= 0){
                    nowH = -1;
                    break;
                }
                nextAttack++;
            }
            
            //현재 시간과 다음 공격 시간이 같지 않다면 -> bandageTime 증가 및 체력 회복
            else {
                bandageTime++;
                nowH += bandage[1];

                //bandageTime과 bandage가 같아지면
                if(bandageTime == bandage[0]) {
                    //수정: 시간 전부 소비한 경우 추가
                    nowH += bandage[2];
                    bandageTime = 0;
                }

                if(nowH > health) {
                    nowH = health;
                }
            }
        }        
        return nowH;
    }
}