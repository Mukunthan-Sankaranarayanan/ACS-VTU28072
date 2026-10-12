import java.util.*;

public class SmartCoursePlanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> courseOrder = new ArrayList<>();

        while (!queue.isEmpty()) {

            int current = queue.poll();

            courseOrder.add(current);

            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (courseOrder.size() != N) {
            System.out.println("IMPOSSIBLE");
        } else {

            System.out.println("Course Order:");

            for (int i = 0; i < courseOrder.size(); i++) {
                System.out.print(courseOrder.get(i));

                if (i < courseOrder.size() - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        sc.close();
    }
}
