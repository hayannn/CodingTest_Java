import java.util.*;
 
class Solution
{
    static int n;
    static int[] array;
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
         
        int T=10;
 
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
 
            int count = 0;
            for (int i = 2; i < n - 2; i++) {
                int max = Math.max(array[i-2],
                        Math.max(array[i-1],
                                Math.max(array[i+1], array[i+2])));
                 
                if (array[i] > max)
                    count += array[i] - max;
            }
            System.out.println("#" + test_case + " " + count);
        }
    }
}