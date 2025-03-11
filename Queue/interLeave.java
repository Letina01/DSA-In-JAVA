package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class interLeave {

    // Function to interleave elements of two queues
    public static Queue<Integer> interLeaveQueue(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> q3 = new LinkedList<>();

        // Interleave the elements from q1 and q2
        while (!q1.isEmpty() || !q2.isEmpty()) {

            // Add one element from q1 if not empty
            if (!q1.isEmpty()) {
                q3.add(q1.poll());
            }

            // Add one element from q2 if not empty
            if (!q2.isEmpty()) {
                q3.add(q2.poll());
            }
        }

        // Return the interleaved queue
        return q3;
    }

    public static void main(String[] args) {
        // Create two queues and add elements
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // Add elements to q1
        q1.add(1);
        q1.add(3);
        q1.add(5);
        q1.add(7);

        // Add elements to q2
        q2.add(2);
        q2.add(4);
        q2.add(6);
        q2.add(8);

        // Interleave the two queues
        Queue<Integer> interleavedQueue = interLeaveQueue(q1, q2);

        // Print the result
        System.out.println("Interleaved Queue: " + interleavedQueue);
    }
}
