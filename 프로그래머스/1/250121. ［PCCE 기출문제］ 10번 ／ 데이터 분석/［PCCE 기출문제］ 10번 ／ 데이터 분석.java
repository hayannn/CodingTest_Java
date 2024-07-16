import java.util.*;

/* 알고리즘
1. list 선언하기(결과를 저장할 리스트)
2. ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"] 를 저장하고 있는 String 선언하기
3. 기준 값 인덱스인 extIndex, 정렬 값 인덱스인 sortIndex 선언하기
4. 2번의 String과 ext, sort_by를 비교해서 3번 설정
5. data 배열 -> extIndex 열의 값 < val_ext인 경우 list에 추가
6. list를 sort_by 기준으로 정렬(오름차순)
7. 결과 반환하기

*/
class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        
    List<int[]> list = new ArrayList<>();

    String[] standard = {"code", "date", "maximum", "remain"};

    int extIndex = 0;
    int sortIndex = 0;

    for(int i=0; i<4; i++){
        if(ext.equals(standard[i])){
            extIndex = i;
        }
        if(sort_by.equals(standard[i])){
            sortIndex = i;
        }
    }

    for(int i=0; i<data.length; i++){
        if(data[i][extIndex] < val_ext){
            list.add(data[i]);
        }
    }
        
    final int newSortIndex = sortIndex;

    Collections.sort(list, (o1, o2) -> o1[newSortIndex] - o2[newSortIndex]);

    return list;
    }
}