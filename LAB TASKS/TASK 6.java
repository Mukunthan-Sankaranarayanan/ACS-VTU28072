import java.util.*;

public class IntelligentCPUTaskScheduler {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < N; i++) {
            char task = sc.next().charAt(0);
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int count : frequency.values()) {
            maxHeap.offer(count);
        }

        int time = 0;

        while (!maxHeap.isEmpty()) {

            List<Integer> temp = new ArrayList<>();

            int cycle = K + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {

                int count = maxHeap.poll();

                count--;

                if (count > 0) {
                    temp.add(count);
                }

                time++;
                cycle--;
            }

            for (int count : temp) {
                maxHeap.offer(count);
            }

            if (!maxHeap.isEmpty() && cycle > 0) {
                time += cycle;
            }
        }

        System.out.println(time);

        sc.close();
    }
}
