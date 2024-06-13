import java.util.*;

public class Main {

    static int N;
    static int M;
    static ArrayList<int[]> house; //집
    static ArrayList<int[]> chicken; //치킨
    static int result = Integer.MAX_VALUE;
    static boolean[] chick;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // 1. N과 M 입력받기(N = 입력받을 줄 수, M = 폐업시키지 않을 치킨집의 최대 개수)
        N = sc.nextInt();
        M = sc.nextInt();

        // 2. N개의 줄 입력받기 -> 집, 치킨집 정보
        house = new ArrayList<>(); //집
        chicken = new ArrayList<>(); //치킨
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                switch(sc.nextInt()){
                    case 1 : //1은 집
                        house.add(new int[]{r,c});
                        break;
                    case 2 : //2는 치킨집
                        chicken.add(new int[]{r,c});
                        break;
                }
            }
        }
        chick = new boolean[chicken.size()];
        combination(0,0);
        System.out.println(result);
    }

    // 3. 치킨 거리 구하기 : 집과 가장 가까운 치킨집 사이의 거리
    //    도시의 치킨 거리 구하기 : 모든 집의 치킨 거리의 합
    public static void combination(int n, int r){
        if(r == M){
            int dist = 0;

            for (int i = 0; i < house.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (chick[j]) {
                        int[] h = house.get(i);
                        int[] c = chicken.get(j);
                        tmp = Math.min(tmp, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                    }
                }
                dist += tmp;
            }
            result = Math.min(result, dist);
            return;
        }
        for (int i = n; i < chick.length; i++) {
            chick[i] = true;
            combination(i+1, r + 1);
            chick[i] = false;
        }

    }
}