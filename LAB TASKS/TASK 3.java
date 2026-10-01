import java.util.*;

public class CircularDeliveryRouteRepair {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void removeCycle(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return;
        }

        slow = head;

        if (slow == fast) {
            // Cycle starts at head
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        fast.next = null;
    }

    static Node reverseKGroup(Node head, int K) {
        if (head == null || K <= 1) {
            return head;
        }

        Node current = head;
        Node newHead = null;
        Node previousGroupEnd = null;

        while (current != null) {

            Node kth = current;
            int count = 1;

            while (count < K && kth != null) {
                kth = kth.next;
                count++;
            }

            if (kth == null) {
                if (previousGroupEnd != null) {
                    previousGroupEnd.next = current;
                }
                break;
            }

            Node nextGroup = kth.next;

            Node prev = nextGroup;
            Node temp = current;

            while (temp != nextGroup) {
                Node next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
            }

            if (newHead == null) {
                newHead = kth;
            }

            if (previousGroupEnd != null) {
                previousGroupEnd.next = kth;
            }

            previousGroupEnd = current;
            current = nextGroup;
        }

        return newHead;
    }

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Node head = null;
        Node tail = null;

        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();

            nodes[i] = new Node(value);

            if (head == null) {
                head = nodes[i];
                tail = nodes[i];
            } else {
                tail.next = nodes[i];
                tail = nodes[i];
            }
        }

        int cyclePosition = sc.nextInt();

        if (cyclePosition != -1) {
            tail.next = nodes[cyclePosition];
        }

        removeCycle(head);

        head = reverseKGroup(head, K);

        printList(head);

        sc.close();
    }
}
