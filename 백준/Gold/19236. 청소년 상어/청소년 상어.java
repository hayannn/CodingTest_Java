import java.util.*;

public class Main {
    static int[][][] Fishes; // 4 X 4 크기 격자에 존재하는 각 물고기의 번호 및 방향 값 넣기

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    static int result = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Fishes = new int[4][4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Fishes[i][j][0] = sc.nextInt();
                Fishes[i][j][1] = sc.nextInt() - 1;
            }
        }

        dfs(0, 0, 0, Fishes);

        System.out.println(result);
    }


    //++ 현재 위치에서 왼쪽으로 회전한 결과 반환
    static int turnLeft(int direction) {
        return (direction + 1) % 8;
    }


    //++ 입력에서 받은 각 물고기별 정보에 따라 물고기를 회전 및 이동 연산하기(방향은 8가지임.)
    static void moveAllFishes(int[][][] array, int nowX, int nowY) {
        // 1번부터 16번까지의 물고기를 차례대로 (낮은 번호부터) 확인
        for (int i = 1; i <= 16; i++) {
            // 해당 물고기의 위치를 찾기
            int[] position = findFish(array, i);
            if (position != null) {
                int x = position[0];
                int y = position[1];
                int direction = array[x][y][1];
                // 해당 물고기의 방향을 왼쪽으로 계속 회전시키며 이동이 가능한지 확인
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];
                    // 해당 방향으로 이동이 가능하다면 이동 시키기
                    if (0 <= nx && nx < 4 && 0 <= ny && ny < 4) {
                        if (!(nx == nowX && ny == nowY)) {
                            int tempDirection = array[x][y][1];
                            array[x][y][1] = direction;
                            int[] temp = array[x][y];
                            array[x][y] = array[nx][ny];
                            array[nx][ny] = temp;
                            break;
                        }
                    }
                    direction = turnLeft(direction);
                }
            }
        }
    }

    // ++ 상어가 현재 위치에서 먹을 수 있는 모든 물고기의 위치 반환
    static List<int[]> getPossiblePositions(int[][][] array, int nowX, int nowY) {
        List<int[]> positions = new ArrayList<>();
        int direction = array[nowX][nowY][1];
        // 현재의 방향으로 쭉 이동하기
        for (int i = 0; i < 4; i++) {
            nowX += dx[direction];
            nowY += dy[direction];
            // 범위를 벗어나지 않는지 확인하며
            if (0 <= nowX && nowX < 4 && 0 <= nowY && nowY < 4) {
                // 물고기가 존재하는 경우
                if (array[nowX][nowY][0] != -1) {
                    positions.add(new int[]{nowX, nowY});
                }
            }
        }
        return positions;
    }

    static void dfs(int nowX, int nowY, int total, int[][][] array) {
        int[][][] copiedArray = new int[4][4][2]; // 배열을 복사
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copiedArray[i][j][0] = array[i][j][0];
                copiedArray[i][j][1] = array[i][j][1];
            }
        }

        total += copiedArray[nowX][nowY][0]; // 현재 위치의 물고기 먹기
        copiedArray[nowX][nowY][0] = -1; // 물고기를 먹었으므로 번호 값을 -1로 변환

        moveAllFishes(copiedArray, nowX, nowY); // 전체 물고기 이동 시키기

        // 이제 다시 상어가 이동할 차례이므로, 이동 가능한 위치 찾기
        List<int[]> positions = getPossiblePositions(copiedArray, nowX, nowY);
        // 이동할 수 있는 위치가 하나도 없다면 종료
        if (positions.size() == 0) {
            result = Math.max(result, total); // 최댓값 저장
            return;
        }
        // 모든 이동할 수 있는 위치로 재귀적으로 수행
        for (int[] position : positions) {
            dfs(position[0], position[1], total, copiedArray);
        }
    }

    // 특정한 번호의 물고기 위치 찾기
    static int[] findFish(int[][][] array, int index) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j][0] == index) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}