import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine().toUpperCase();

        // 입력된 문자열의 길이가 2글자 이상 15글자 이하인지 확인
        if (words.length() < 2 || words.length() > 15) {
            System.out.println("2글자 이상 15글자 이하의 문자열을 입력해야 합니다.");
            return;
        }

        int count = 0;

        for (int i = 0; i < words.length(); i++) {
            char character = words.charAt(i);
            int wtonumber = character - 'A';

            count += (wtonumber / 3) + 3;
            if (character == 'S' || character == 'V' || character == 'Y' || character == 'Z') {
                count -= 1;
            }               
        }
        System.out.print(count);
    }
}
