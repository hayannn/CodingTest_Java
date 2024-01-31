import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 숫자 입력받기
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        // 2. 입력받은 숫자 뒤집기
        int reverse1 = reverseNumber(num1);
        int reverse2 = reverseNumber(num2);

        // 3. 뒤집은 숫자 비교하고 결과 출력
        Result(reverse1, reverse2);
    }

    // 2' :  숫자를 뒤집는 메소드
    private static int reverseNumber(int number) {
        int reverse = 0;
        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }
        return reverse;
    }

    // 3' : 뒤집은 숫자를 비교하고 결과 출력
    private static void Result(int reverse1, int reverse2) {
        // 4. 뒤집은 두 숫자 비교하기
        if (reverse1 > reverse2) {
            System.out.println(reverse1);
        } else if (reverse1 < reverse2) {
            System.out.println(reverse2);
        } else {
            System.out.println("두 수가 동일합니다.");
        }
    }
}
