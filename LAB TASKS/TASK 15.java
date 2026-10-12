import java.util.*;

public class ExpeditionResourceOptimizationSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();

        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {

                dp[i][w] = dp[i - 1][w];

                if (weight[i] <= w) {
                    dp[i][w] = Math.max(
                        dp[i][w],
                        dp[i - 1][w - weight[i]] + value[i]
                    );
                }
            }
        }

        int maximumValue = dp[N][W];

        List<Integer> selectedItems = new ArrayList<>();

        int remainingCapacity = W;

        for (int i = N; i >= 1; i--) {

            if (dp[i][remainingCapacity] != dp[i - 1][remainingCapacity]) {
                selectedItems.add(i);
                remainingCapacity -= weight[i];
            }
        }

        Collections.reverse(selectedItems);

        System.out.println("MaximumValue = " + maximumValue);
        System.out.println("SelectedItems:");

        for (int i = 0; i < selectedItems.size(); i++) {
            System.out.print(selectedItems.get(i));

            if (i < selectedItems.size() - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        sc.close();
    }
}
