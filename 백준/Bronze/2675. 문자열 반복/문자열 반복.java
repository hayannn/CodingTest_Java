import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<n; i++){
            int num = scanner.nextInt();
            String string = scanner.next();

            for(int j=0; j<string.length(); j++){
                for(int k=0; k<num; k++){
                    System.out.print(string.charAt(j));
                }
            }
            System.out.println();
        }
    }
}