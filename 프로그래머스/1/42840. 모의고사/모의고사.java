import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] answer = {};
        
        //숫자 찍기 패턴
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        //맞춘 개수 담을 배열
        int[] score = new int[3];
        
        //맞춘 개수 구하기
        for(int i = 0; i<answers.length; i++){
            if(answers[i] == one[i % 5]) score[0]++; //1번 수포자는 5개 길이의 패턴 중 1개를 정답으로 내놓을 것.
            if(answers[i] == two[i % 8]) score[1]++; //2번 수포자는 8개 길이의 패턴 중 1개를 정답으로 내놓을 것.
            if(answers[i] == three[i % 10]) score[2]++; //3번 수포자는 10개 길이의 패턴 중 1개를 정답으로 내놓을 것.
        }
        
        //가장 많이 정답을 맞춘 개수 계산
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        List<Integer> list = new ArrayList<>();
        
        //가장 많이 맞춘 사람 오름차순으로 정렬
        for(int i=0; i < 3; i++){
            if( maxScore == score[i]) list.add(i+1);
        }
        return list;
    }
}