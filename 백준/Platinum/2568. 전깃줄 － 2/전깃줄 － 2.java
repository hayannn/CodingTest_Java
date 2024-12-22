import java.util.*;

class Line {
    int a, b;

    public Line(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {

    static int n;
    static Line[] lines = new Line[500001];
    static List<Line> ary;
    static List<Integer> result = new ArrayList<>();
    static int[] index = new int[500001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ary = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines[a] = new Line(a, b);
        }

        for (int i = 0; i < 500001; i++) {
            if (lines[i] == null) continue;

            if (ary.isEmpty() || ary.get(ary.size() - 1).b < lines[i].b) {
                ary.add(lines[i]);
                index[lines[i].a] = ary.size() - 1;
            } 
            if (!(ary.isEmpty() || ary.get(ary.size() - 1).b < lines[i].b)) {
                int idx = getCorrectIndex(0, ary.size() - 1, lines[i].b);
                ary.set(idx, lines[i]);
                index[lines[i].a] = idx;
            }
        }

        int limit = ary.size() - 1;
        for (int i = 500000; i >= 0; i--) {
            if (lines[i] == null) continue;
            if (index[i] == limit) {
                limit--;
            } else {
                result.add(lines[i].a);
            }
        }

        System.out.println(n - ary.size());
        Collections.reverse(result);
        for (int res : result) {
            System.out.println(res);
        }
    }

    public static int getCorrectIndex(int left, int right, int value) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (ary.get(mid).b >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}