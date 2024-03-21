//오후 7시 9분 ~ 

/*
[알고리즘]
1. words 배열과 queries 배열을 비교
   - 이진 탐색을 위해 정렬하기
   - 매치되는 개수를 출력하기(answer)
2. 이진 탐색 구현하기(별도 메서드)
   - words 배열 : 2개 이상
   - queries 배열 : 2개 이상
   - 중복 제거(중복 시 1개로 통합)
   - 와일드 카드 문자 ?만 포함 가능하도록
3. 단어 앞부분 검사(와일드 카드가 앞에 올 경우)
4. 단어 뒷부분 검사(와일드 카드가 뒤에 올 경우)
*/
import java.util.*;

class Solution {

    // 모든 단어들을 길이마다 나누어서 저장하기 위한 리스트
    static ArrayList<ArrayList<String>> array = new ArrayList<>();
    // 모든 단어들을 길이마다 나누어서 뒤집어 저장하기 위한 리스트
    static ArrayList<ArrayList<String>> reverseArray = new ArrayList<>();

    public int[] solution(String[] words, String[] queries) {
        ArrayList<Integer> Arrayanswer = new ArrayList<>();

        for (int i = 0; i < 10001; i++) { // "각 단어의 길이는 1이상 10,000이하로 빈 문자열인 경우는 없습니다." -> 즉 0부터 100001까지!
            array.add(new ArrayList<>());
            reverseArray.add(new ArrayList<>());
        }

        // 모든 단어를 접미사 와일드카드 배열, 접두사 와일드카드 배열에 각각 삽입
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            array.get(word.length()).add(word); // 단어를 삽입
            word = (new StringBuffer(word)).reverse().toString();
            reverseArray.get(word.length()).add(word); // 단어를 뒤집어서 삽입
        }

        // 이진 탐색을 수행하기 위해 각 단어 리스트 정렬 수행
        for (int i = 0; i < 10001; i++) {
            Collections.sort(array.get(i));
            Collections.sort(reverseArray.get(i));
        }
        
        // 키워드 배열 queries 계산 과정
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int res = 0;
            if (query.charAt(0) != '?') { // fro??
                res = countByRange(array.get(query.length()), query.replaceAll("\\?", "a"), query.replaceAll("\\?", "z"));
            }
            else { // ????o
                query = (new StringBuffer(query)).reverse().toString();
                res = countByRange(reverseArray.get(query.length()), query.replaceAll("\\?", "a"), query.replaceAll("\\?", "z"));
            }
            // 단어 개수 저장하기
            Arrayanswer.add(res);
        }

        // 다시 배열로 바꾸기
        int[] answer = new int[Arrayanswer.size()];
        for (int i = 0; i < Arrayanswer.size(); i++) {
            answer[i] = Arrayanswer.get(i);
        }
        return answer;
    }
    
    //이진 탐색 구현
    public int lowerBound(ArrayList<String> array, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            // arr[mid]가 target보다 사전순으로 같거나 뒤에 있다면
            if (array.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public int upperBound(ArrayList<String> array, String target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            // arr[mid]가 target보다 사전순으로 뒤에 있다면
            if (array.get(mid).compareTo(target) > 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public int countByRange(ArrayList<String> array, String leftValue, String rightValue) {
        // 유의: lowerBound와 upperBound는 end 변수의 값을 배열의 길이로 설정
        int rightIndex = upperBound(array, rightValue, 0, array.size());
        int leftIndex = lowerBound(array, leftValue, 0, array.size());
        return rightIndex - leftIndex;
    }
}