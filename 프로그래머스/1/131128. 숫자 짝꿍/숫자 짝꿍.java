import java.util.*;

/*알고리즘
<시간 초과로 인해 String이 아닌 StringBuilder 사용>
- x와 y를 숫자별로 정리하기
- 9(길이)부터 역순으로 보면서
    - 겹치는 숫자는 append
- 짝꿍이 없는 경우 -> -1 반환
- 짝꿍이 0으로만 구성 -> 0 반환
*/

class Solution {
    public String solution(String X, String Y) {
        StringBuilder stringBuilder = new StringBuilder();
 
        int[] xArray = new int[10];
        for(String x : X.split("")){
            xArray[Integer.parseInt(x)]++;
        }
        
        int[] yArray = new int[10];
        for(String y : Y.split("")) {
            yArray[Integer.parseInt(y)]++;
        }
        
        for(int i=9; i>=0; i--){
            while(xArray[i] > 0 && yArray[i] > 0){
                stringBuilder.append(i);
                xArray[i]--;
                yArray[i]--;
            }
        }
        if("".equals(stringBuilder.toString())){
            return "-1";
        }
        
        if("0".equals(stringBuilder.toString().substring(0,1))) {
            return "0";
        }
        
        return stringBuilder.toString();
    }
}