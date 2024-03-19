//첫 풀이 : 13:12 ~ 13:35
//재풀이 : ~ 14:17
/*
0. Comparable로 Game 클래스 - stage, fail 변수 작성하기
1. 배열 선언 및 스테이지 변수 선언하기
   - 스테이지 개수 역시 선언 -> 이 때, 반복문의 바깥에 선언해줘야 함!!!
2. 스테이지에 있는 사람 수 계산하기
3. 실패율 계산하기
   - 스테이지 도달했으나 클리어 못한 플레이어 수 / 스테이지 도달한 플레이어 수
4. 스테이지 return : 실패율이 높은 사용자부터 내림차순 정렬
*/

import java.util.*;

class Game implements Comparable<Game> {

    private int stage;
    private double fail;

    public Game(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    public int getStage() {
        return this.stage;
    }

    @Override
    public int compareTo(Game other) {
        if (this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.fail, this.fail);
    }
}


class Solution {
    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        ArrayList<Game> GameList = new ArrayList<>();
        int stageLength = stages.length;

        for(int i=1; i<=N; i++){
            int player = 0; //스테이지 안의 플레이어 수
            for(int j=0; j<stages.length; j++){
                if(stages[j] == i){ //스테이지가 계속되는 동안
                    player++;
                }
            }

            //실패율 계산하기
            double fail = 0;

            //int stageLength = stages.length;

            if(stageLength >= 1){
                fail = (double) player / stageLength;
            }
            GameList.add(new Game(i, fail));
            stageLength -= player;
        }

        Collections.sort(GameList);

        for(int i=0; i<N; i++){
            answer[i] = GameList.get(i).getStage();
        }
        return answer;
    }
}