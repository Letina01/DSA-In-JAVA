package Queue;
//queue into priority queue

import java.util.LinkedList;
import java.util.Queue;

public class QueueSorter {

    // Function to push the front element to the end of the queue qsize times
    static void frontelement(Queue<Integer> q, int qsize) {
        // Base condition: if the queue size is zero or negative, stop recursion
        if (qsize <= 0) {
            return;
        }

        // Add the front element to the end and remove it from the front
        q.add(q.peek());
        q.poll();

        // Recursive call to process the next element
        frontelement(q, qsize - 1);
    }

    // Function to insert an element into the sorted position in the queue
    static void insertelement(Queue<Integer> q, int val, int qsize) {
        // Base case: if the queue is empty or we reached the position, insert the element
        if (qsize == 0 || q.isEmpty()) {
            q.add(val);
            return;
        }

        // If the current element is greater than or equal to the front element
        if (val >= q.peek()) {
            q.add(val);
            // Call to move the front element to the back
            frontelement(q, qsize);
        } else {
            // Remove the front element and add it to the end
            q.add(q.peek());
            q.poll();

            // Recursively insert the element in the remaining queue
            insertelement(q, val, qsize - 1);
        }
    }

    // Function to sort the queue using recursion
    static void sortqueue(Queue<Integer> q) {
        // Base case: if the queue is empty, return
        if (q.isEmpty()) {
            return;
        }

        // Remove the front item and sort the remaining queue
        int item = q.poll();
        sortqueue(q);

        // Insert the removed item back in sorted order
        insertelement(q, item, q.size());
    }

    // Main function to test the sorting function
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(3);
        q.add(4);
        q.add(2);
        q.add(8);
        q.add(1);
        q.add(7);

        // Before sorting: 3 4 2 8 1 7
        System.out.println("Original queue: " + q);

        // Sort the queue
        sortqueue(q);

        // Print the sorted queue
        System.out.print("Sorted queue: ");
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}
