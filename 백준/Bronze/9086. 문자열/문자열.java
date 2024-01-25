import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();


        for(int i=0; i<A; i++){
            String input = sc.next();
            String P = String.valueOf(input.charAt(0));
            String Q = String.valueOf(input.charAt(input.length()-1));
            System.out.println(P+Q);
        }
        sc.close();

    }
}
