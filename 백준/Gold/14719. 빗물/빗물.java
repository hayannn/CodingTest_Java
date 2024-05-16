import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		int H = sc.nextInt();
		int W = sc.nextInt();
		
		int[] arr = new int[W];
		for(int i=0; i<W; i++) {
			arr[i] = sc.nextInt();
		}
		
		int result = 0;
		
		for(int i = 1; i < W - 1; i++) {
            int minH = Math.min(maxH(arr, 0, i), maxH(arr, i + 1, W)); //i를 기준으로 왼쪽에 있는 높이 중 최대 높이 | 오른쪽에 있는 높이 중 최대 높이를 비교 -> 더 작은 수 찾기
            if(arr[i] < minH) { // 현재 위치의 값이 최솟값보다 작을 때
                result += minH - arr[i]; // 빗물의 양 계산하여 결과에 더함
            }
        }
        System.out.print(result);
    }
    
    // 주어진 범위에서 최대 높이를 찾는 함수
    static int maxH(int[] arr, int start, int end) {
        int max = 0;
        for(int i = start; i < end; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}