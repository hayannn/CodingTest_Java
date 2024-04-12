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