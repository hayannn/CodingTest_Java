import java.util.*;

public class Main {

    static int N;
    static int K;
    static String[] word;

    //방문한 알파벳
    static boolean visited[] = new boolean[26];

    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        //버퍼 비우기(초기회)
        sc.nextLine();

        //a, c, i, n, t 방문을 true로 설정
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        //최소한 a, c, i, n, t의 5개가 필요하기 때문
        if (K < 5) {
            System.out.println(0);
            return;
        }

        //알파벳은 모두 가능함을 뜻함.
        if (K == 26) {
            System.out.println(N);
            return;
        }

        word = new String[N];
        for (int i = 0; i<N; i++) {
            word[i] = sc.nextLine();
        }

        //조합 진행
        combination(0, 0);
        System.out.println(max);
    }


    //백트래킹을 이용해 조합 계산
    public static void combination(int index, int start){
        if(index==K-5) {
            //현재 조합으로 읽을 수 있는 단어 수 세기
            int count = readable();
            max = Math.max(max, count);
            return;
        }

        for(int i=start; i<26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(index + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    //읽을 수 있는 단어의 수 계산
    public static int readable(){
        int count = 0;
        for (int i = 0; i < N; i++) {
            boolean read = true;
            //String cutWord = word[i].substring(4, word[i].length() - 4); // "anta"와 "tica" 부분을 제거
            for (int j = 4; j < word[i].length() - 4; j++) {
                if (!visited[word[i].charAt(j) - 'a']) {
                    read = false;
                    break;
                }
            }
            if (read) {
                count++;
            }
        }
        return count;
    }
}