package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class queueReversal {

    // Function to reverse the queue
    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all elements of the queue into the stack
        while (!q.isEmpty()) {
            stack.push(q.remove());
        }

        // Step 2: Pop all elements from the stack back into the queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        return q;
    }
    //Reversing the first K elements of a Queue
    /*import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static Queue<Integer> reverseFirstKElements(Queue<Integer> q, int k) {
        // Check for edge cases
        if (q == null || k <= 0 || k > q.size()) {
            return q;
        }
        
        // Create a stack to hold the first K elements
        Stack<Integer> stack = new Stack<>();
        
        // Push the first K elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }
        
        // Pop the elements from the stack back into the queue
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        
        // Move the remaining elements from the front of the queue to the back to maintain the order
        int size = q.size();
        for (int i = 0; i < size - k; i++) {
            q.add(q.remove());
        }
        
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        int k = 3;
        System.out.println("Original queue: " + queue);
        queue = reverseFirstKElements(queue, k);
        System.out.println("Queue after reversing first " + k + " elements: " + queue);
    }
}

                }*/


    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Add elements to the queue
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        // Reverse the queue
        q = reverseQueue(q);

        // Print the reversed queue
        System.out.println("Reversed Queue:");
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
