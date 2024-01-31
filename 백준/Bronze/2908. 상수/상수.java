import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 숫자 입력받기
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // 2. 입력받은 첫번째 숫자 뒤집기
        int reverse1 = 0; //num1을 뒤집은 숫자
        while(num1 != 0) {
            int digit = num1 % 10;
            reverse1 = reverse1 * 10 + digit;
            num1 /= 10;
        }

        // 3. 입력받은 두번째 숫자 뒤집기
        int reverse2 = 0; //num2를 뒤집은 숫자
        while(num2 != 0) {
            int digit = num2 % 10;
            reverse2 = reverse2 * 10 + digit;
            num2 /= 10;
        }

        // 4. 뒤집은 두 숫자 비교하기(삼항연산자 사용 X)
        if(reverse1 > reverse2) {
            System.out.println(reverse1);
        }
        else if(reverse1 < reverse2) {
            System.out.println(reverse2);
        }

        else {
            System.out.print("두 수가 동일합니다.");
        }
    }
}