import java.util.*;

/* 알고리즘
- 1자리부터 n자리까지의 조합 만들기
  - 모든 조합을 HashSet에 저장해서 중복 없애기
- HashSet에 저장된 숫자 중 소수만 카운트 -> 소수 개수 반환
*/

class Solution {
    public int solution(String numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            generateCombinations(numbers, "", i, visited, uniqueNumbers);
        }

        int answer = 0;
        for (int num : uniqueNumbers) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public void generateCombinations(String str, String current, int length, boolean[] visited, Set<Integer> uniqueNumbers) {
        if (current.length() == length) {
            uniqueNumbers.add(Integer.parseInt(current));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                generateCombinations(str, current + str.charAt(i), length, visited, uniqueNumbers);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}