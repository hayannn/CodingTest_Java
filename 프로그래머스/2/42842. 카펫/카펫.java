/* 알고리즘
- 총 면적 계산
  - 카펫의 전체 면적은 brown + yellow
  - width * height 값 구하기
- width, height
  - width는 3부터 시작
  - width가 totalArea러 나누어떨어지면 -> height 계산
- 내부
  - width - 2, height - 2 -> yellow 영역 만들기가 되는지 확인
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        int totalArea = brown + yellow;
        
        for (int width = 3; width <= totalArea / 3; width++) {
            if (totalArea % width == 0) {
                int height = totalArea / width;
                
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[] {Math.max(width, height), Math.min(width, height)};
                }
            }
        }
        return null;
    }
}