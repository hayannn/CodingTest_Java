import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().trim();

        if(string.isEmpty())
            System.out.println('0');
        else
            System.out.println(string.split(" ", -1).length);
    }
}
