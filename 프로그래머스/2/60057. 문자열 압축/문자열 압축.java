class Solution {
    public int solution(String s) {
        /*
        - s 입력받기
        - 문자열을 1개 ~ n개까지 자르기(or 문자열 반복 찾기)
        - 그 중 가장 짧은 길이 출력하기
        */
        int answer = s.length();

        //문자열을 1개 ~ n개까지 자르기(or 문자열 반복 찾기)
        for(int i = 1; i<s.length() / 2+1; i++){
            int compressLength = compress(s, i);
            answer = Math.min(answer, compressLength);
        } 
        return answer;
    }
    
    public int compress(String s, int unit){
        StringBuilder compressDone = new StringBuilder();
        String now = "";
        int count = 1;
        
        for (int j = 0; j <= s.length(); j += unit) {
            int start = j;
            int end = Math.min(j + unit, s.length());

            String sub = s.substring(start, end);

            if (now.equals(sub)) {
                count++;
            } else {
                if (count > 1) {
                    compressDone.append(count);
                }
                compressDone.append(now);
                now = sub;
                count = 1;
            }
        }
        
        if (count > 1) {
            compressDone.append(count);
        }
        compressDone.append(now);
        
        return compressDone.length();
    }
}