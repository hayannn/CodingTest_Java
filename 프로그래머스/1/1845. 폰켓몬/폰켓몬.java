//오전 9시 24분 ~ 오전 9시 43분
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        //nums에 입력받은 숫자로 몇 종류의 폰켓몬이 있는지 구하면 되려나? 중복을 제거해 숫자의 종류 개수를 구하면 될듯?
        
        Arrays.sort(nums);
        
        int length = 1; //배열의 길이(최소 1종류가 있기 때문에 초기화를 1로 설정)
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){ //배열의 이전 숫자(i-1)와 현재 숫자(i)를 비교
                length++;
            }
        }
        int max = nums.length / 2; //최대로 선택이 가능한 폰켓몬의 수(N/2마리를 선택하므로)
        return Math.min(length, max); // 배열에서 가져온 폰켓몬의 종류 수 vs 최대로 선택할 수 있는 폰켓몬 수 -> 더 작은 값을 반환
    }
}