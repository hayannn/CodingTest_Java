import java.util.*;

/* 알고리즘
- DFS + 백트래킹으로 banned_id 순서대로 가능한 user_id 조합 탐색
- banned_id와 user_id : * 패턴으로
- Set을 사용해 순서 및 중복 제거
- 조합 수 반환
*/

class Solution {
    Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(new HashSet<>(), 0, user_id, banned_id);
        return result.size();
    }

    void dfs(Set<String> currentSet, int depth, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            if (currentSet.size() == banned_id.length) {
                result.add(new HashSet<>(currentSet));
            }
            return;
        }

        for (String user : user_id) {
            if (!currentSet.contains(user) && isMatch(user, banned_id[depth])) {
                currentSet.add(user);
                dfs(currentSet, depth + 1, user_id, banned_id);
                currentSet.remove(user);
            }
        }
    }

    boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) return false;

        for (int i = 0; i < user.length(); i++) {
            if (banned.charAt(i) != '*' && user.charAt(i) != banned.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}