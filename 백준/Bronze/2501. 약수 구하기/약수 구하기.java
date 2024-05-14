import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if (N % i == 0) {
                arr.add(i);
            }
        }
        Collections.sort(arr);

        if(K <= arr.size()) {
            System.out.println(arr.get(K-1));
        } else {
            System.out.println(0);
        }
    }
}