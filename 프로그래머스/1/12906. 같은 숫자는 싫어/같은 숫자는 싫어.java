import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        
        int value = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != value){
                answerList.add(arr[i]);
                value = arr[i];
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}