import java.util.*;

public class Main {

  static int N;
  static int[][] TD;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    TD = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i + 1; j++) {
        TD[i][j] = sc.nextInt();
      }
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j <= i; j++) {
        int LUp, Up;
        if (j == 0) {
          LUp = 0;
        } else {
          LUp = TD[i - 1][j - 1];
        }

        if (j == i) {
          Up = 0;
        } else {
          Up = TD[i - 1][j];
        }
        TD[i][j] = TD[i][j] + Math.max(LUp, Up);
      }
    }
    int result = 0;
    for (int i = 0; i < N; i++) {
      result = Math.max(result, TD[N - 1][i]);
    }
    System.out.println(result);
  }
}