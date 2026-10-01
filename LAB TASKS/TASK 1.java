import java.util.*;

public class TrafficSignalCongestionAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] vehicles = new int[N];

        for (int i = 0; i < N; i++) {
            vehicles[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        int windowSum = 0;
        for (int i = 0; i < K; i++) {
            windowSum += vehicles[i];
        }

        int maxSum = windowSum;

        for (int i = K; i < N; i++) {
            windowSum += vehicles[i] - vehicles[i - K];

            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        System.out.println(maxSum);

        sc.close();
    }
}
