import java.util.*;

class Tunnel implements Comparable<Tunnel> {
    int PlanetA;
    int PlanetB;
    int distance;

    public Tunnel(int PlanetA, int PlanetB, int distance) {
        this.PlanetA = PlanetA;
        this.PlanetB = PlanetB;
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Tunnel other) {
        return this.distance - other.distance;
    }
}

public class Main {
    static int[] P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = i;
        }

        List<Tunnel> tunnels = new ArrayList<>();

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) { // x, y, z 좌표 각각
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            points[i] = new Point(x, y, z, i);
        }

        for (int dim = 0; dim < 3; dim++) {
            final int dimension = dim; // 람다에서 사용할 final 변수 생성
            Arrays.sort(points, Comparator.comparingInt(p -> p.coords[dimension]));
            for (int i = 1; i < N; i++) {
                int cost = Math.abs(points[i].coords[dimension] - points[i - 1].coords[dimension]);
                tunnels.add(new Tunnel(points[i].index, points[i - 1].index, cost));
            }
        }

        int totalCost = kruskal(tunnels);
        System.out.println(totalCost);
    }

    static int kruskal(List<Tunnel> tunnels) {
        Collections.sort(tunnels);

        int totalCost = 0;
        for (Tunnel tunnel : tunnels) {
            if (find(tunnel.PlanetA) != find(tunnel.PlanetB)) {
                union(tunnel.PlanetA, tunnel.PlanetB);
                totalCost += tunnel.distance;
            }
        }

        return totalCost;
    }

    static int find(int x) {
        if (P[x] == x) {
            return x;
        }
        return P[x] = find(P[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            P[b] = a;
        }
    }

    static class Point {
        int[] coords;
        int index;

        public Point(int x, int y, int z, int index) {
            this.coords = new int[]{x, y, z};
            this.index = index;
        }
    }
}