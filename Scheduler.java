import java.util.*;

public class Scheduler {

    /* schedule meeting using a greedy algorithm */
    private static List<int[]> scheduleMeeting(List<int[]> intervals) {
        List<int[]> result = new ArrayList<>();
        Collections.sort(intervals, new IntervalComparator());
        result.add(intervals.get(0));
        int currentEnd = intervals.get(0)[1];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start < currentEnd) {
                continue;
            } else {
                currentEnd = end;
                result.add(interval);
            }
        }
        return result;
    }

    /* parse and make interval list from user */
    private static List<int[]> getIntervals(String line) {
        List<int[]> result = new ArrayList<>();
        Scanner sc = new Scanner(line);
        while (sc.hasNext()) {
            String[] time = sc.next().split("-");
            int[] interval = new int[] { Integer.parseInt(time[0]), Integer.parseInt(time[1]) };
            result.add(interval);
        }
        sc.close();
        return result;
    }

    private static void print(List<int[]> list) {
        for (int[] item : list) {
            System.out.println(item[0] + " - " + item[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What are the meeting intervals? ");
        String line = scanner.nextLine();
        List<int[]> intervals = getIntervals(line);
        List<int[]> optimalAppointments = scheduleMeeting(intervals);
        System.out.println("The optimal meetings are: ");
        print(optimalAppointments);
        scanner.close();
    }
}

class IntervalComparator implements Comparator<int[]> {
    public int compare(int[] a1, int[] a2) {
        return a1[1] - a2[1];
    }
}
