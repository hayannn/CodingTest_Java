import java.util.*;

public class Main{

    public static boolean[][] array;
    public static int min = 64;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        array = new boolean[N][M];

        for(int i=0; i<N; i++){
            String string = scanner.next();
            for(int j=0; j<M; j++){
                if (string.charAt(j) == 'W') {
                    array[i][j] = true;
                } else {
                    array[i][j] = false;
                }
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for(int i=0; i<N_row; i++){
            for(int j=0; j<M_col; j++){
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y){
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean first = array[x][y];

        for(int i=x; i<end_x; i++){
            for(int j=y; j<end_y; j++){
                if(array[i][j] != first){
                    count++;
                }
                first = (!first); 
            }
            first = !first;
        }
        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }

}