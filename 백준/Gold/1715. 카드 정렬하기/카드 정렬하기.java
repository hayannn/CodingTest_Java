import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        //Arrays.sort(arr);

        int result = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.offer(arr[i]);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            result += sum;
            pq.offer(sum);
        }
        System.out.println(result);
    }
}