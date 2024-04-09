import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
        	
            int n = sc.nextInt();
            int[][] multi = new int[n][n];

            int r = 0, c = 0, num = 1;

            while (num <= n * n) {
                // 우
                while (c < n && multi[r][c] == 0) {
                    multi[r][c++] = num++;
                }
                c--; // 범위를 벗어난 열을 되돌아감
                r++; // 행을 증가시켜 범위 안으로 이동

                // 하
                while (r < n && multi[r][c] == 0) {
                    multi[r++][c] = num++;
                }
                r--; // 범위를 벗어난 행을 되돌아감
                c--; // 열을 감소시켜 범위 안으로 이동

                // 좌
                while (c >= 0 && multi[r][c] == 0) {
                    multi[r][c--] = num++;
                }
                c++; // 범위를 벗어난 열을 되돌아감
                r--; // 행을 감소시켜 범위 안으로 이동

                // 상
                while (r >= 0 && multi[r][c] == 0) {
                    multi[r--][c] = num++;
                }
                r++; // 범위를 벗어난 행을 되돌아감
                c++; // 열을 증가시켜 범위 안으로 이동
            }

            System.out.println("#" + test_case);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(multi[i][j] + " ");
                System.out.println();
            }
        }
    }
}