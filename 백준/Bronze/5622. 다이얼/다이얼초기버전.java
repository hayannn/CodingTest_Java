import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine();


        if(words.length() < 2 || words.length() > 15 || !isAllUpperCase(words)){
            System.out.print("단어는 2 이상 15이하로 입력해야 하며, 알파벳 대문자만 입력해주세요.");
        } else {
            int count = 0;
            int length = words.length();
            for (int i = 0; i < length; i++) {
                switch (words.charAt(i)) { //charAt(string 문자열 중 한글자를 char 타입으로 변환
                case 'A':
                case 'B':
                case 'C':
                    count += 3;
                    break;

                case 'D':
                case 'E':
                case 'F':
                    count += 4;
                    break;

                case 'G':
                case 'H':
                case 'I':
                    count += 5;
                    break;

                case 'J':
                case 'K':
                case 'L':
                    count += 6;
                    break;

                case 'M':
                case 'N':
                case 'O':
                    count += 7;
                    break;

                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    count += 8;
                    break;

                case 'T':
                case 'U':
                case 'V':
                    count += 9;
                    break;

                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    count += 10;
                    break;
                }
            }
            System.out.println(count);
        }
    }
    private static boolean isAllUpperCase(String string){
        for(char c : string.toCharArray()){
            if(!Character.isUpperCase(c)){
                return false;
            }
        }
        return true;
    }
}
