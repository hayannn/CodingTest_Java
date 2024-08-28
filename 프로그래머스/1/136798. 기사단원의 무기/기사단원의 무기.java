import java.util.*;

/*알고리즘
- 1부터 number까지의 약수의 개수를 구해서 limit와 비교
    - 약수의 개수 > limit일 경우, power를 증가
    - 약수의 개수 <= limit일 경우, answer(약수의 개수)를 증가
- 별도 메서드 : 약수의 개수를 구하는 메서드
- 합성수 특징 이용 -> i가 제곱일일 때까지 반복하는 for문
    - 제곱근일 경우 count를 증가
    - 제곱근이 아닌 약수인 경우 count + 2로 추가하기
*/


class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (divisorCount(i) <= limit)
                answer += divisorCount(i);
            else
                answer += power;
        }
        return answer;
    }
    
    //약수 개수 메서드
    public int divisorCount(int number) {
        int count = 0;
        
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number){
                count++;
            }
            else if (number % i == 0) {
                count += 2;
            }
        }
        return count;
    }
}