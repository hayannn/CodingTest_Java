import java.util.*;
public class Main {

    static int N;
    static int[] T;
    static int[] P;
    static int[] d;
    static int maxCon; //최대 수익 -> 전역변수로 위치 변경
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        for(int i=0; i<N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        d = new int[N + 1]; //d 크기를 N+1로 변경

        for(int i = N-1; i>=0; i--){

            int time = T[i] + i;

            if(time<=N){ //상담이 되는 경우
                //T[i]+i는 상담을 시작하는 날짜(T[i])부터 상담을 진행하는 데 걸리는 일 수(i)를 더한 값
                //상담을 시작하고 나면 그 일 수만큼은 무조건 상담이 불가하기 때문!
                d[i] = Math.max((P[i] + d[time]), maxCon);
                maxCon = d[i];
            } else {
                d[i] = maxCon;
            }
        }
        System.out.println(maxCon);
    }
}