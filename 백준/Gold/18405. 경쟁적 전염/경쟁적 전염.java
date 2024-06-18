import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result;

    static int tT;
    static int  tX;
    static int tY;


    static class Virus implements Comparable<Virus> {
        int type;
        int x;
        int y;
        int time;

        public Virus(int type, int x, int y, int time) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Virus o) {
            return Integer.compare(this.type, o.type);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N][N];
        List<Virus> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] != 0){
                    list.add(new Virus(arr[i][j], i , j, 0));
                }
            }
        }

        Collections.sort(list);

        tT = sc.nextInt();
        tX = sc.nextInt()-1;
        tY = sc.nextInt()-1;

        bfs(list, tT, tX, tY);


        //System.out.println(result);
    }

    public static void bfs(List<Virus> list, int tT, int tX, int tY) {
        Queue<Virus> queue = new LinkedList<>(list);

        while(!queue.isEmpty()){
            Virus current = queue.poll();
            int x = current.x;
            int y = current.y;
            int time = current.time;

            if(time == tT) {
                System.out.println(arr[tX][tY]);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if(arr[nx][ny] == 0){
                    arr[nx][ny] = current.type;
                    queue.offer(new Virus(current.type, nx, ny, time + 1));
                }
            }
        }
        System.out.println(arr[tX][tY]);
    }
}