import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] Pieces = new int[6]; //입력할 개수
        for(int i = 0; i<6; i++) {
            Pieces[i] = scanner.nextInt();
        }

        int[] Chess = {1, 1, 2, 2, 2, 8}; //초기 개수

        int[] Result = new int[6]; //결과

        for(int i = 0; i<6; i++) {
            Result[i] = Chess[i] - Pieces[i]; // 결과 = 초기 개수 - 입력한 개수
            System.out.print(Result[i] + " ");
        }
    }
}