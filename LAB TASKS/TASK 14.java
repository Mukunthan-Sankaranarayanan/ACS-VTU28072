import java.util.*;

public class EventHallReservationManager {

    static class Event {
        int start;
        int end;

        Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Event[] events = new Event[N];

        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            events[i] = new Event(start, end);
        }

        Arrays.sort(events, (a, b) -> {
            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.start, b.start);
        });

        int count = 0;
        int lastEndTime = 0;

        for (Event event : events) {

            if (event.start >= lastEndTime) {
                count++;
                lastEndTime = event.end;
            }
        }

        System.out.println("MaximumEvents = " + count);

        sc.close();
    }
}
