/* 알고리즘
- n % 3으로 가장 뒤 자리 수를 결정
    - r == 0일 때는 자릿수 처리를 위해 n-- (자리 내림 보정)
- 각 자리의 값을 문자열로 변환해 앞에 붙이기
- 최종 문자열을 반환
*/

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] nums = {"4", "1", "2"};

        while (n > 0) {
            int r = n % 3;
            n /= 3;
            if (r == 0) n--;
            sb.insert(0, nums[r]);
        }

        return sb.toString();
    }
}