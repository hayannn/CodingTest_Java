import java.util.*;

/*알고리즘
1. 방법의 수를 세는 count 선언
2. DFS 실행하기(numbers, target, index, sum)
3. count 리턴하기

4. 별도 메서드 : DFS
- 현재의 인덱스가 numbers 배열의 끝까지 도달한 경우
    - sum이 타겟 넘버와 일치한다면 -> count++;
*/


class Solution {
    
    static int count;
    
    public int solution(int[] numbers, int target) {
        
        count = 0;
        
        dfs(numbers, target, 0, 0);
        return count;
    }
    
    public static void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        dfs(numbers, target, index+1, sum + numbers[index]);
        dfs(numbers, target, index+1, sum - numbers[index]);
    }
}