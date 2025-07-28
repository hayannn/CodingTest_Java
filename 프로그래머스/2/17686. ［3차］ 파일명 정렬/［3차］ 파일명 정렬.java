import java.util.*;
import java.util.regex.*;

/* 알고리즘
- 정규 표현식 : ^([^0-9]+)([0-9]{1,5})(.*)$ 패턴으로 HEAD, NUMBER, TAIL 분리
- Arrays.sort() + 람다식: 커스텀 정렬 로직을 람다식으로 구현
- HEAD 먼저 비교 -> HEAD가 같으면 NUMBER 비교
*/

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            // 정규표현식 : HEAD, NUMBER 추출
            Pattern pattern = Pattern.compile("^([^0-9]+)([0-9]{1,5})(.*)$");
            Matcher m1 = pattern.matcher(o1);
            Matcher m2 = pattern.matcher(o2);
            
            m1.matches();
            m2.matches();
            
            String head1 = m1.group(1).toLowerCase();
            String head2 = m2.group(1).toLowerCase();
            int num1 = Integer.parseInt(m1.group(2));
            int num2 = Integer.parseInt(m2.group(2));
            
            // HEAD 먼저 비교
            int headCompare = head1.compareTo(head2);
            if (headCompare != 0) {
                return headCompare;
            }
            
            // HEAD가 같으면 -> NUMBER 비교
            return Integer.compare(num1, num2);
        });
        
        return files;
    }
}
