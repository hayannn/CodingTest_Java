import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextLine()) {
                String words = scanner.nextLine();

                if (words.length() > 100) {
                    System.out.println("100글자가 넘으면 안됩니다.");
                } else if (words.matches("^[a-zA-Z\\s0-9]+$")) {
                    System.out.println(words);
                } else {
                    System.out.println("문자열 형식이 올바르지 않습니다.");
                }
            } else {
                break;
            }
        }
        scanner.close();
    }
}