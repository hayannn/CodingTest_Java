/* 알고리즘
- 각 스킬트리에서 유효한 스킬만 추출
  - 주어진 스킬트리에서 skill에 포함된 문자만 남기기(문자열 필터링)
- 필터링된 스킬트리와 skill 비교
- 만족하면 -> count++
*/

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;

        for (String tree : skill_trees) {
            StringBuilder filtered = new StringBuilder();
            for (char c : tree.toCharArray()) {
                if (skill.indexOf(c) != -1) {
                    filtered.append(c);
                }
            }
            if (skill.startsWith(filtered.toString())) {
                count++;
            }
        }

        return count;
    }
}