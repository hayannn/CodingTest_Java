import java.util.*;

/* 알고리즘
- 주어진 수식을 순차적으로 탐색하면서 숫자는 numList에, 연산자는 opList에 저장
- 수식 내 포함된 연산자만 골라 existOperators에 저장 (`+`, `-`, `*` 중)
- existOperators에 대해 모든 우선순위 순열을 백트래킹으로 생성
- 각 연산자 우선순위 순열에 대해서 다음을 수행
  - numList와 opList 복사
  - 현재 우선순위에 따라 연산자를 하나씩 처리
  - 처리 대상 연산자를 찾으면 해당 위치의 숫자 두 개를 연산한 뒤 결과를 다시 리스트에 삽입하고, 연산자 제거
  - 이 과정을 연산자 리스트가 빌 때까지 반복
- 연산 결과 : 숫자 1개(절댓값이 최대인지 확인 -> 갱신)
- 모든 우선순위 조합에 대해 반복한 후 최댓값 반환
*/

class Solution {

    String[] operators = {"+", "-", "*"};
    long maxAnswer = 0;

    public long solution(String expression) {
        List<Long> numList = new ArrayList<>();
        List<String> opList = new ArrayList<>();

        parseExpression(expression, numList, opList);

        List<String> existOperators = new ArrayList<>();
        for (String op : operators) {
            if (expression.contains(op)) existOperators.add(op);
        }

        permuteOperators(existOperators, new boolean[existOperators.size()], new ArrayList<>(), numList, opList);

        return maxAnswer;
    }

    private void parseExpression(String expr, List<Long> numList, List<String> opList) {
        int idx = 0;
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                numList.add(Long.parseLong(expr.substring(idx, i)));
                opList.add(String.valueOf(ch));
                idx = i + 1;
            }
        }
        numList.add(Long.parseLong(expr.substring(idx)));
    }

    private void permuteOperators(List<String> ops, boolean[] visited, List<String> path,
                                  List<Long> numList, List<String> opList) {
        int n = ops.size();
        if (path.size() == n) {
            long result = calculate(new ArrayList<>(numList), new ArrayList<>(opList), path);
            maxAnswer = Math.max(maxAnswer, Math.abs(result));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.add(ops.get(i));
            permuteOperators(ops, visited, path, numList, opList);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    private long calculate(List<Long> nums, List<String> ops, List<String> priority) {
        for (String op : priority) {
            for (int i = 0; i < ops.size(); ) {
                if (ops.get(i).equals(op)) {
                    long res = apply(nums.remove(i), nums.remove(i), op);
                    nums.add(i, res);
                    ops.remove(i);
                    continue;
                }
                i++;
            }
        }
        return nums.get(0);
    }

    private long apply(long a, long b, String op) {
        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        return a * b;
    }
}