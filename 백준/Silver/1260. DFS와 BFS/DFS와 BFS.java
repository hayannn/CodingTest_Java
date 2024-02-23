import java.util.*;

public class Main {

    static int[][] tree;
    static boolean[] visited;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //정점 개수
        int M = sc.nextInt(); //간선 개수
        int V = sc.nextInt(); //시작정점번호

        tree = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            tree[a][b] = 1;
            tree[b][a] = 1;
        }
        
        visited = new boolean[N+1];
        dfs(V); //깊이 우선 탐색
        System.out.println();

        Arrays.fill(visited, false);
        bfs(V); //너비 우선 탐색
        System.out.println();
    }

    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");

        if(v == tree.length) return;

        for(int i=1; i<tree.length; i++){
            if(tree[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while(!queue.isEmpty()){
            int n = queue.poll();

            for(int j=1; j<tree.length; j++){
                if(tree[n][j] != 0 && !visited[j]){
                    visited[j] = true;
                    System.out.print(j + " ");
                    queue.add(j);
                }
            }
        }
    }
}
