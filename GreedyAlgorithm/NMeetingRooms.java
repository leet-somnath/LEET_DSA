import java.util.*;

public class NMeetingRooms {
    // A helper class to represent a meeting
    static class Meeting {
        int start;
        int end;
        int pos;
        
        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    // Method to get the maximum number of meetings
    static void maxMeetings(int start[], int end[], int n) {
        List<Meeting> meetings = new ArrayList<>();
        
        // Populate the list with Meeting objects
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        // Sort meetings by their end time, and by position if end time is the same
        Collections.sort(meetings, (m1, m2) -> {
            if (m1.end != m2.end) {
                return m1.end - m2.end;
            } else {
                return m1.pos - m2.pos;
            }
        });

        List<Integer> result = new ArrayList<>();
        int lastEndTime = meetings.get(0).end;
        result.add(meetings.get(0).pos);

        // Find the meetings that can be accommodated
        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > lastEndTime) {
                result.add(meetings.get(i).pos);
                lastEndTime = meetings.get(i).end;
            }
        }

        // Print the result
        System.out.println("The order in which the meetings will be performed is:");
        for (int pos : result) {
            System.out.print(pos + " ");
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 5, 7, 9, 9};
        maxMeetings(start, end, n);
    }
}
