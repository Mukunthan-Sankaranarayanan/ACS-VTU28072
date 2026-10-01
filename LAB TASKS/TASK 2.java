import java.util.*;

public class WarehouseProductFrequencyManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int productId = sc.nextInt();
            frequency.put(productId, frequency.getOrDefault(productId, 0) + 1);
        }

        int maxFrequency = 0;
        int resultProduct = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int productId = entry.getKey();
            int count = entry.getValue();

            if (count > maxFrequency ||
                (count == maxFrequency && productId < resultProduct)) {
                maxFrequency = count;
                resultProduct = productId;
            }
        }

        System.out.println(resultProduct + " " + maxFrequency);

        sc.close();
    }
}
