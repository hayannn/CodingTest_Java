import java.util.*;

public class Main {

    static int N;
    static int C;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        C = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[N - 1] - arr[0];
        int result = binarySearch(arr, C, start, end);

        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int C, int start, int end) {
        int result = 0;

        while (start <= end) {
            int count = 1;
            int prev = arr[0];
            int mid = start + (end - start) / 2;

            for (int i = 1; i < N; i++) {
                if (arr[i] - prev >= mid) {
                    count++;
                    prev = arr[i];
                }
            }

            if (count >= C) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
