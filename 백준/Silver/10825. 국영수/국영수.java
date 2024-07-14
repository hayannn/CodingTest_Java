import java.util.*;

class Student implements Comparable<Student> {

    private String name;
    private int K;
    private int E;
    private int M;

    public Student(String name, int K, int E, int M) {
        this.name = name;
        this.K = K;
        this.E = E;
        this.M = M;
    }

    public String getName() {
        return this.name;
    }
    @Override
    public int compareTo(Student other) {
        if (this.K == other.K && this.E == other.E && this.M == other.M) {
            return this.name.compareTo(other.name);
        }
        if (this.K == other.K && this.E == other.E) {
            return Integer.compare(other.M, this.M);
        }
        if (this.K == other.K) {
            return Integer.compare(this.E, other.E);
        }
        return Integer.compare(other.K, this.K);
    }
}

public class Main {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int K = sc.nextInt();
            int E = sc.nextInt();
            int M = sc.nextInt();
            students.add(new Student(name, K, E, M));
        }

        Collections.sort(students);

        for (int i = 0; i < N; i++) {
            System.out.println(students.get(i).getName());
        }
    }
}