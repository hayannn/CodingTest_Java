//현재 이 풀이는 인텔리제이에서는 잘 되지만, 백준에서는 틀린 것으로 채점된 상태.
import java.util.*;
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

            if (wtonumber < 2) count += 3;
            else if (wtonumber < 5) count += 4;
            else if (wtonumber < 8) count += 5;
            else if (wtonumber < 11) count += 6;
            else if (wtonumber < 14) count += 7;
            else if (wtonumber < 18) count += 8;
            else if (wtonumber < 21) count += 9;
            else if (wtonumber < 25) count += 10;
            else count += 11;
        }
        System.out.print(count);
    }
}
