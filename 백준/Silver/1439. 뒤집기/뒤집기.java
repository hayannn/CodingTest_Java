//2시 32분 시작 ~ 2시 58분
import java.util.*;

public class Main {

    public static int zero = 0; //전부 0으로 바꾸는 그룹(넣을때마다 뒤집는 횟수가 됨.)
    public static int one = 0; //전부 1로 바꾸는 그룹(넣을때마다 뒤집는 횟수가 됨.)
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int result = str.charAt(0); //첫번째 수
        if(result == '1'){
            zero += 1; //모두 0인 그룹의 수를 증가
        }
        else{
            one += 1; //모두 1인 그룹의 수를 증가
        }

        //다음 수부터는 여기서 진행
        for(int i=0; i<str.length()-1; i++){
            int num = str.charAt(i); //다음 수
            int numNext = str.charAt(i+1); //다음 수의 다음 수

            if(num != numNext) { //다음 수와 그 다음 수가 다르면?
                if(numNext == '1'){ //numNext가 1이라면
                    zero += 1; //모두 0인 그룹의 수를 증가
                }else{ //다음 수와 그 다음 수가 같다면?
                    one += 1; //모두 1인 그룹의 수를 증가
                }
            }
        }
        System.out.println(Math.min(zero, one)); //모두 0인 그룹과, 모두 1인 그룹을 비교해 더 작은 그룹 크기를 출력
    }
}