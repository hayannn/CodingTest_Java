import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        System.out.println(stringTokenizer.countTokens());
    }
}