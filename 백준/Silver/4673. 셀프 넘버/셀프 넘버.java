public class Main {
    static int n;
    static boolean[] selfNum = new boolean[10001];

    public static void main(String[] args){
        //셀프 넘버
        for(int i=1; i<10001; i++) {
            n = d(i);
            if (n < 10001) {
                selfNum[n] = true; //리턴되는 수는 생성자가 있는 수(출력 X)이기 때문
            }
        }

        //셀프 넘버 출력
        for(int i=1; i<10001; i++) {
            if(!selfNum[i]) {
                System.out.println(i);
            }
        }
    }

    public static int d(int num){
        int sum = num; // 1. sum을 num으로 초기화하기
        while(num!=0){ // 2. 각 자리수를 더하기 위한 반복문 작성
            sum = sum + (num % 10); // 3. num의 첫번째 자리 수를 구하기 위해 %10을 한 다음 sum에 더하기
            num = num / 10; // 4. 그 이후 /10을 진행해 10을 줄이기
        }
        return sum; // 5. 출력이 되면 "안되는" 값이 리턴!(즉, 결과에서는 뒤집어줘야 한다는 것)
    }
}