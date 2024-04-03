import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int W;
    static int[][] TD = new int[1002][1002];
    static int[][] eventPos = new int[1002][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer	stringTokenizer;
        StringBuilder result = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());

        for(int i = 1; i <= W; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            eventPos[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            eventPos[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        result.append(moveCar(1,0,0)).append("\n");

        int carOne = 0;
        int carTwo = 0;
        for(int i = 1; i <= W; i++) {
            int oneDistance = dist(1, carOne, i);

            if(TD[carOne][carTwo] - oneDistance == TD[i][carTwo]) {
                carOne = i;
                result.append(1).append("\n");
            }else {
                carTwo = i;
                result.append(2).append("\n");
            }
        }
        System.out.println(result);
    }

    static int[] start(int carNum, int coord) {
        if (coord == 0) {
            if (carNum == 1) {
                return new int[]{1, 1};
            } else {
                return new int[]{N, N};
            }
        } else {
            return eventPos[coord];
        }
    }


    static int moveCar(int eventCase, int indexOne, int indexTwo) {
        if(eventCase > W) {
            return 0;
        }

        if(TD[indexOne][indexTwo] != 0) {
            return TD[indexOne][indexTwo];
        }

        int oneMoveCount = moveCar(eventCase+1, eventCase, indexTwo) + dist(1, indexOne, eventCase);
        int twoMoveCount = moveCar(eventCase+1, indexOne, eventCase) + dist(2, indexTwo, eventCase);

        return TD[indexOne][indexTwo] = Math.min(oneMoveCount, twoMoveCount);
    }

    static int dist(int carNum, int startIdx, int endIdx) {
        int[] startPos = start(carNum, startIdx);

        return Math.abs(startPos[0] - eventPos[endIdx][0]) + Math.abs(startPos[1] - eventPos[endIdx][1]);
    }
}