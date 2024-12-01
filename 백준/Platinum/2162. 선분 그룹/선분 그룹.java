import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] lines = new Line[n];
        parent = new int[n];

        // 선분 입력 및 부모 초기화
        for (int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            parent[i] = i; // 각 선분은 자기 자신을 부모로 초기화
        }

        // 선분 간 교차 여부 체크 후 union
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (meet(lines[i], lines[j])) {
                    union(i, j);
                }
            }
        }

        // 그룹 카운트 및 최대 그룹 크기 계산
        Map<Integer, Integer> groupCount = new HashMap<>();
        int maxSize = 1;

        for (int i = 0; i < n; i++) {
            int groupParent = getParent(i);
            groupCount.put(groupParent, groupCount.getOrDefault(groupParent, 0) + 1);
            maxSize = Math.max(maxSize, groupCount.get(groupParent));
        }

        // 출력: 그룹의 개수와 최대 그룹 크기
        System.out.println(groupCount.size());
        System.out.println(maxSize);
    }

    // 부모를 찾는 함수 (경로 압축)
    static int getParent(int idx) {
        if (parent[idx] != idx) {
            parent[idx] = getParent(parent[idx]);  // 경로 압축
        }
        return parent[idx];
    }

    // 두 선분이 교차하는지 확인하는 함수
    static boolean meet(Line l1, Line l2) {
        int res1 = ccw(l1, l2.x1, l2.y1) * ccw(l1, l2.x2, l2.y2);
        int res2 = ccw(l2, l1.x1, l1.y1) * ccw(l2, l1.x2, l1.y2);

        if (res1 == 0 && res2 == 0) {
            // 일직선인 경우, 선분이 겹치는지 체크
            return Math.min(l1.x1, l1.x2) <= Math.max(l2.x1, l2.x2) &&
                   Math.min(l2.x1, l2.x2) <= Math.max(l1.x1, l1.x2) &&
                   Math.min(l1.y1, l1.y2) <= Math.max(l2.y1, l2.y2) &&
                   Math.min(l2.y1, l2.y2) <= Math.max(l1.y1, l1.y2);
        } else {
            return res1 <= 0 && res2 <= 0; // 교차
        }
    }

    // CCW를 이용한 방향 계산 함수
    static int ccw(Line l1, int x3, int y3) {
        int x1 = l1.x1, y1 = l1.y1, x2 = l1.x2, y2 = l1.y2;
        long result = (long) (x2 - x1) * (y3 - y1) - (long) (y2 - y1) * (x3 - x1);
        if (result == 0) return 0;  // 일직선
        return result > 0 ? 1 : -1; // 반시계 방향, 시계 방향
    }

    // 두 선분을 합치는 함수 (Union)
    static void union(int i, int j) {
        int rootI = getParent(i);
        int rootJ = getParent(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ; // 두 그룹을 합침
        }
    }

    // 선분을 나타내는 클래스
    static class Line {
        int x1, y1, x2, y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}