import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String B = sc.next();
        sc.close();

        int sum = 0;
        for(int i = 0; i < A; i++){
            sum += B.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}