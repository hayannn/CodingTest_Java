import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static List<Integer>[] adj;
    static int[][] town;
    static boolean[] visited;

    static int result;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = sc.nextInt();
        }
        
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        town = new int[N+1][2];
        visited = new boolean[N+1];

        dfs(1);

        result = Math.max(town[1][0] , town[1][1]);

        System.out.println(result);
    }

    public static void dfs(int n){
        visited[n] = true;
        town[n][0] = 0;
        town[n][1] = arr[n];

        for (int i = 0; i < adj[n].size(); i++) {
            int neighbor = adj[n].get(i);
            if (!visited[neighbor]) {
                dfs(neighbor);
                town[n][0] += Math.max(town[neighbor][0], town[neighbor][1]);
                town[n][1] += town[neighbor][0];
            }
        }
    }
}