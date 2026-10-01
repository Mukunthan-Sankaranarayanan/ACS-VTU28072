import java.util.*;

public class EmergencyRouteMeetingPoint {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
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

    static Node findLCA(Node root, int node1, int node2) {

        if (root == null) {
            return null;
        }

        if (root.data == node1 || root.data == node2) {
            return root;
        }

        Node leftLCA = findLCA(root.left, node1, node2);
        Node rightLCA = findLCA(root.right, node1, node2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        if (leftLCA != null) {
            return leftLCA;
        }

        return rightLCA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
        }

        int node1 = sc.nextInt();
        int node2 = sc.nextInt();

        Node root = buildTree(values);

        Node lca = findLCA(root, node1, node2);

        if (lca != null) {
            System.out.println("LCA = " + lca.data);
        }

        sc.close();
    }
}
