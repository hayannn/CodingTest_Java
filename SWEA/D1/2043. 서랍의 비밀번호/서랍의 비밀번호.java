import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;

        while (K != P) {
            K++;
            count++;
        }
        System.out.println(count+1);
    }
}