import java.util.*;
public class Main {

    static int N;
    static int[] num;
    static int[] oper;
    static int maxResult = Integer.MIN_VALUE; // 초기 최대값을 가장 작은 값으로 설정
    static int minResult = Integer.MAX_VALUE; // 초기 최소값을 가장 큰 값으로 설정
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
        }

        oper = new int[4];
        for(int i=0; i<4; i++){
            oper[i] = sc.nextInt();
        }

        dfs(num[0], 1); // 초기 값은 수열의 첫 번째 숫자부터 시작

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    public static void dfs(int oneNum, int index){
        if(index == N) { // 모든 숫자를 다 사용한 경우
            maxResult = Math.max(maxResult, oneNum);
            minResult = Math.min(minResult, oneNum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;

                int nextNum = 0;
                switch (i) {
                    case 0:
                        nextNum = oneNum + num[index];
                        break;
                    case 1:
                        nextNum = oneNum - num[index];
                        break;
                    case 2:
                        nextNum = oneNum * num[index];
                        break;
                    case 3:
                        nextNum = oneNum / num[index];
                        break;
                }

                dfs(nextNum, index + 1);
                oper[i]++; // 재귀 호출이 끝난 후 연산자 개수 복구
            }
        }
    }
}