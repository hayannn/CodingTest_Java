import java.util.*;

/* 알고리즘
- Union-Find
    - 각 방을 "다음 방 번호"로 연결 -> 중복 최소화
    - assignRoom(room) 함수를 통해 빈 방을 찾고 배정
    - 방이 이미 배정되었으면, 그 방의 "다음 방 번호"를 따라가며 빈 방 찾기
- 경로 압축
    - 방을 찾을 때마다 방의 부모를 갱신하여, 다음 방 번호로 직접 연결
    - 반복적인 조회를 최적화하여 찾는 시간을 줄임
*/

class Solution {
    static Map<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = assignRoom(room_number[i]);
        }

        return answer;
    }

    static long assignRoom(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }

        long next = assignRoom(map.get(room));
        map.put(room, next);
        return next;
    }
}