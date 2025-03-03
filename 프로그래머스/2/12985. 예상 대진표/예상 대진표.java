/* 알고리즘
- 짝수이면 절반, 홀수이면 절반 올림 수행(3번 -> 2번, 4번 -> 2번)
- 라운드가 끝나면 -> answer++
- a == b가 될 때까지 반복
*/
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(true){
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
            
            if(a == b) break;
        }
        return answer;
    }
}