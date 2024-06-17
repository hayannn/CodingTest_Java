import java.util.*;

public class Main {

    static int N;
    static int[] T;
    static int[] P;
    static int[] d;
    static int maxCon;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        for(int i=0; i<N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        d = new int[N + 1];

        for(int i = N-1; i>=0; i--){

            int time = T[i] + i;

            if(time<=N){
                d[i] = Math.max((P[i] + d[time]), maxCon);
                maxCon = d[i];
            } else {
                d[i] = maxCon;
            }
        }
        System.out.println(maxCon);
    }
}