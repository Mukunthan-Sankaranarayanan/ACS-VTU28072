import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[] {
                nums1[i] + nums2[0],
                i,
                0
            });
        }

        while (!minHeap.isEmpty() && result.size() < k) {

            int[] current = minHeap.poll();

            int i = current[1];
            int j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {

                minHeap.offer(new int[] {
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }

        return result;
    }
}
