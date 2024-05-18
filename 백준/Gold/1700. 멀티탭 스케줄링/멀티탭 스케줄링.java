import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[K];
		for(int i=0; i<K; i++) {
			arr[i] = sc.nextInt();
		}
		
		int count = 0;
		
		Set<Integer> multiTab = new HashSet<>();
		
		for(int i=0; i<K; i++) {
			//멀티탭에 이미 있다면 넘어가도록
			if(multiTab.contains(arr[i])) {
				continue;
			}
			
			//멀티탭이 꽉찬다면
			if(multiTab.size() == N) {
				int far = -1; //멀티탭에서 가장 먼 전기용품
				int out = -1; //멀티탭에서 뺄 전기용품
				
				//멀티탭에 있는 전기용품 중 가장 나중에 사용할 것 찾기
				for(int j : multiTab) {
					int idx = -1;
					for (int k = i + 1; k < K; k++) {
                        if (arr[k] == j) {
                            idx = k;
                            break;
                        }
                    }
                    if (idx == -1) {
                        out = j;
                        break;
                    }
                    if (idx > far) {
                        far = idx;
                        out = j;
                    } 
                }
				// 찾은 전기용품을 멀티탭에서 빼고 현재 전기용품을 꽂음
                multiTab.remove(out);
                multiTab.add(arr[i]);
                count++;
            } else {
                // 멀티탭에 빈 구멍이 있는 경우 현재 전기용품을 꽂음
                multiTab.add(arr[i]);
            }
		}
		System.out.println(count);	
	}

}