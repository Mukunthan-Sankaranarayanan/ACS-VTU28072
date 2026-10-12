import java.util.*;

public class MuseumTreasureRoutePlanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] treasure = new int[N];

        for (int i = 0; i < N; i++) {
            treasure[i] = sc.nextInt();
        }

        if (N == 1) {
            System.out.println(treasure[0]);
            sc.close();
            return;
        }

        int prev2 = 0;
        int prev1 = 0;

        for (int i = 0; i < N; i++) {

            int take = prev2 + treasure[i];

            int skip = prev1;

            int current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(prev1);

        sc.close();
    }
}
