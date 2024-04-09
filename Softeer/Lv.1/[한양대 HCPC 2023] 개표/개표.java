import java.io.*;
import java.util.*;

public class Main {

    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int A = n / 5;
            int B = n % 5;
            for(int j = 0; j < A ; j++){
                System.out.print("++++ ");
            }
            for(int j = 0; j < B ; j++){
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
