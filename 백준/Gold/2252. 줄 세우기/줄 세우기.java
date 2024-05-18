import java.util.*;

public class Main {
	
	static int N;
	static int M;

	 static List<Integer>[] List;
	
	static int[] indegree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		List = new ArrayList[N+1];
		indegree = new int[N+1];
		
		
		for (int i = 1; i <= N; i++) {
			List[i] = new ArrayList<>();
		}

        for(int i=0; i<M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            List[from].add(to);
            indegree[to]++;
        }
		bfs();
	}
	
	public static void bfs(){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 진입차수가 0인 노드를 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }
        
        while (!pq.isEmpty()) {
            int n = pq.poll();
            System.out.print(n + " ");
            
            for (int i : List[n]) {
                indegree[i]--; // 해당 정점에서 나가는 간선을 제거
                    
                if (indegree[i] == 0) {
                    pq.add(i);
                }
            }
        }
    }
}