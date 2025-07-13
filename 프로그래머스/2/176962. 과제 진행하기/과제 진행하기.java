import java.util.*;

/* 알고리즘
- 입력
  - 과제 시작 시간 : 분 단위 정수로 변환
  - plans 배열 -> 시작 시간 기준으로 오름차순 정렬

- 스택
  - 진행 중인 과제를 멈추면 스택에 저장(후입선출)
  - 새로운 과제 시작 -> 현재 과제를 멈추고 스택에 push

- 과제 처리
  - 다음 과제 시작 전 남은 시간 : gap
  - gap 동안 스택 과제(=가장 최근에 멈춘 것)를 이어서 진행
  - gap > 과제 소요 시간 : 해당 과제 완료 후 answer에 추가, gap 감소
  - gep < 과제 소요 시간 : 남은 소요 시간만큼만 진행 -> 다시 스택에 push

- 반환
  - 스택에 남은 과제들을 최근에 멈춘 순서대로 answer에 추가
*/

class Solution {
    static class Task {
        String name;
        int start;
        int duration;

        Task(String name, int start, int duration) {
            this.name = name;
            this.start = start;
            this.duration = duration;
        }
    }

    public String[] solution(String[][] plans) {
        int n = plans.length;
        List<Task> tasks = new ArrayList<>();
        for (String[] plan : plans) {
            String name = plan[0];
            String[] time = plan[1].split(":");
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int duration = Integer.parseInt(plan[2]);
            tasks.add(new Task(name, start, duration));
        }

        tasks.sort(Comparator.comparingInt(t -> t.start));

        Stack<Task> stack = new Stack<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Task curr = tasks.get(i);
            int nextStart = (i < n - 1) ? tasks.get(i + 1).start : Integer.MAX_VALUE;
            stack.push(new Task(curr.name, curr.start, curr.duration));
            int gap = nextStart - (curr.start);

            while (!stack.isEmpty() && gap > 0) {
                Task top = stack.pop();
                if (top.duration <= gap) {
                    answer.add(top.name);
                    gap -= top.duration;
                } else {
                    top.duration -= gap;
                    stack.push(top);
                    break;
                }
            }
        }

        while (!stack.isEmpty()) {
            answer.add(stack.pop().name);
        }

        return answer.toArray(new String[0]);
    }
}