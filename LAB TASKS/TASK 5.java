import java.util.*;

public class FactoryTemperatureMonitor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] temperature = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            temperature[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                   temperature[stack.peek()] <= temperature[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = temperature[stack.peek()];
            }

            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i]);

            if (i < N - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        sc.close();
    }
}
