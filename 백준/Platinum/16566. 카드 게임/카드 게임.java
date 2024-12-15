import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] cards = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int[] parent = new int[M];
        for (int i = 0; i < M; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int pick = Integer.parseInt(st.nextToken());
            int index = findCard(cards, pick);
            int availableIndex = find(parent, index);
            sb.append(cards[availableIndex]).append("\n");
            union(parent, availableIndex, availableIndex + 1);
        }

        System.out.print(sb);
    }

    private static int findCard(int[] cards, int pick) {
        int low = 0, high = cards.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (cards[mid] <= pick) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    private static void union(int[] parent, int x, int y) {
        if (y < parent.length) {
            parent[x] = find(parent, y);
        }
    }
}