import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] array = new int[26];

        for(int i = 0; i < array.length; i++){
            array[i] = -1; // 배열 생성하여 모두 -1로 초기화
        }

        String st = sc.nextLine();

        for(int i = 0; i < st.length(); i++){
            char ch = st.charAt(i);

            if(array[ch - 'a'] == -1){
                array[ch - 'a'] = i;
            }
        }

        for(int val : array){
            System.out.print(val + " ");
        }
    }
}
