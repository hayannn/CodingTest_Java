import java.util.*;

public class Main {
	
	static int N;
	static int M;
	
	static int[][] arr;
	
	static boolean[] visited;
	
	static int[] distance; // 각 도시까지의 최소 비용을 저장할 배열

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1. 입력받기
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			Arrays.fill(arr[i], -1); // 가중치 0인 경우
		}
		
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			// 같은 경로의 버스가 여러 개일 수 있으므로, 최소 비용 버스를 저장
			if (arr[from][to] == -1 || arr[from][to] > cost) {
			    arr[from][to] = cost;
			}
		}
		
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		//2. 계산
		visited = new boolean[N+1];
		distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE); // 최소 비용을 저장할 배열을 무한대로 초기화
		
		
		dijkstra(start);
		
		System.out.println(distance[end]);
	}
	
	//3. bfs -> dijkstra로 변경 + 우선순위 큐 사용!!
	public static void dijkstra(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 비용이 작은 순서대로 정렬하는 우선순위 큐
		pq.add(new int[]{start, 0}); // 시작 도시와 비용(0) 추가
		distance[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] n = pq.poll();
			int city = n[0];
			int cost = n[1];
			
			if(visited[city]) continue; //이미 방문한 도시 무시
			
			visited[city] = true;
			
			for(int i=1; i<=N; i++) {
				if(arr[city][i] != -1 && distance[i] > distance[city] + arr[city][i]) {
					distance[i] = distance[city] + arr[city][i]; // 시작 도시부터 현재 도시까지의 최소 비용 + 현재 도시에서 다음 도시까지의 비용
                    pq.add(new int[]{i, distance[i]});
				}
			}
		}		
	}
}