import java.util.*;
public class Main {

    static int N;
    static int[] d;
    static int maxSol;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        Integer[] arr = new Integer[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        d = new int[N];
        Arrays.fill(d, 1);

        for(int i = 1; i<N; i++){
            for(int j = 0; j< i; j++) {
                if(arr[j] > arr[i]){
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
        }

        for(int i=0; i<N; i++){
            maxSol = Math.max(maxSol, d[i]);
        }
        System.out.println(N - maxSol);

    }
}