import java.util.*;

public class EmployeeHierarchyAnalyzer {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int height(Node root) {
        if (root == null) {
            return -1;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static Node buildTree(int[] values) {

        if (values.length == 0 || values[0] == -1) {
            return null;
        }

        Node root = new Node(values[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {

            Node current = queue.poll();

            if (index < values.length && values[index] != -1) {
                current.left = new Node(values[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < values.length && values[index] != -1) {
                current.right = new Node(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
        }

        Node root = buildTree(values);

        int treeHeight = height(root);

        int levels = treeHeight + 1;

        System.out.println("Height = " + treeHeight);
        System.out.println("Levels = " + levels);

        sc.close();
    }
}
