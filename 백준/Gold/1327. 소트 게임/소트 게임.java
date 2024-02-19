import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        StringBuilder initialSequence = new StringBuilder();
        for (int num : arr) {
            initialSequence.append(num);
        }

        String result = bfs(arr, n, k);
        System.out.println(result);
    }

    private static String bfs(int[] arr, int n, int k) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Node initialNode = new Node(arr, 0);
        queue.add(initialNode);
        visited.add(initialNode.toString());

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int[] currentArr = currentNode.arr;

            if (Arrays.equals(currentArr, getSortedArray(n))) {
                return Integer.toString(currentNode.depth);
            }

            for (int i = 0; i <= n - k; i++) {
                int[] nextArr = Arrays.copyOf(currentArr, n);
                reverseSubArray(nextArr, i, i + k - 1);

                String nextArrString = Arrays.toString(nextArr);
                if (!visited.contains(nextArrString)) {
                    visited.add(nextArrString);
                    queue.add(new Node(nextArr, currentNode.depth + 1));
                }
            }
        }

        return "-1";
    }

    private static void reverseSubArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static int[] getSortedArray(int n) {
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArray[i] = i + 1;
        }
        return sortedArray;
    }

    static class Node {
        int[] arr;
        int depth;

        Node(int[] arr, int depth) {
            this.arr = arr;
            this.depth = depth;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num);
            }
            return sb.toString();
        }
    }
}