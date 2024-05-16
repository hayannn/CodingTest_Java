import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
 
        Scanner sc = new Scanner(System.in);
         
        int N = sc.nextInt();
         
        String[] arr = new String[N+1];
         
        for(int i=1; i<=N; i++) {
             
            arr[i] = String.valueOf(i);
             
             if (arr[i].contains("3") || arr[i].contains("6") || arr[i].contains("9")) {
                for(int j=0; j<arr[i].length(); j++) {
                    if(arr[i].charAt(j) == '3' || arr[i].charAt(j) == '6' || arr[i].charAt(j) == '9') {
                        System.out.print("-");
                    }
                }
                System.out.print(" ");
            }
            else {
            System.out.print(arr[i] + " ");
            }
        }
    }
}