import java.util.*;

public class MultiCityDeliveryOptimizationSystem {

    static class HeapNode implements Comparable<HeapNode> {
        int value;
        int listIndex;
        int elementIndex;

        HeapNode(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(HeapNode other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int K = sc.nextInt();

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int size = sc.nextInt();

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                list.add(sc.nextInt());
            }

            lists.add(list);
        }

        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(
                    new HeapNode(lists.get(i).get(0), i, 0)
                );
            }
        }

        List<Integer> merged = new ArrayList<>();

        while (!minHeap.isEmpty()) {

            HeapNode current = minHeap.poll();

            merged.add(current.value);

            int nextIndex = current.elementIndex + 1;
            int listIndex = current.listIndex;

            if (nextIndex < lists.get(listIndex).size()) {
                minHeap.offer(
                    new HeapNode(
                        lists.get(listIndex).get(nextIndex),
                        listIndex,
                        nextIndex
                    )
                );
            }
        }

        System.out.println("Merged:");

        for (int i = 0; i < merged.size(); i++) {
            System.out.print(merged.get(i));

            if (i < merged.size() - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        System.out.println("TopK:");

        for (int i = merged.size() - 1;
             i >= merged.size() - K;
             i--) {

            System.out.print(merged.get(i));

            if (i > merged.size() - K) {
                System.out.print(" ");
            }
        }

        System.out.println();

        sc.close();
    }
}
