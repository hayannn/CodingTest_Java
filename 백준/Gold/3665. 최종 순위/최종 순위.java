import java.util.*;

public class Main {

    static int T;
    static int N;
    static int[] Indegree;
    static boolean[][] TD;
    static int[] Rank;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            N = scanner.nextInt();

            Indegree = new int[N + 1];
            TD = new boolean[N + 1][N + 1];

            Rank = new int[N];
            for (int i = 0; i < N; i++) {
                Rank[i] = scanner.nextInt();
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int teamOne = Rank[i];
                    int teamTwo = Rank[j];
                    TD[teamOne][teamTwo] = true;
                    Indegree[teamTwo]++;
                }
            }


            int M = scanner.nextInt();
            for (int i = 0; i < M; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (TD[a][b]) {
                    TD[a][b] = false;
                    TD[b][a] = true;
                    Indegree[a]++;
                    Indegree[b]--;
                } else {
                    TD[a][b] = true;
                    TD[b][a] = false;
                    Indegree[a]--;
                    Indegree[b]++;
                }
            }

            String result = "";

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (Indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            boolean isUnique = true;
            int count = 0;
            while (!queue.isEmpty()) {
                if (queue.size() > 1) {
                    isUnique = false;
                    break;
                }
                int now = queue.poll();
                count++;
                result += now + " ";
                for (int i = 1; i <= N; i++) {
                    if (TD[now][i]) {
                        Indegree[i]--;
                        if (Indegree[i] == 0) {
                            queue.offer(i);
                        }
                    }
                }
            }
            if (!isUnique || count < N) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }
}