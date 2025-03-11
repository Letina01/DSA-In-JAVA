package Queue;
import java.util.Stack;

public class queueUsingStack {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    // Enqueue operation: Add an element to the queue
    public static void enqueue(int data) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push the new element onto s1
        s1.push(data);

        // Move all elements back to s2 from s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue operation: Remove and return the front element from the queue
    public static int dequeue() {
        // If s1 is empty, the queue is empty
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        // Return the top element from s1 (front of the queue)
        return s1.pop();
    }

    // Peek operation: Get the front element of the queue without removing it
    public static int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s1.peek();
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);

        System.out.println("Dequeued: " + dequeue()); // Should print 10
        System.out.println("Peek: " + peek());        // Should print 20
        System.out.println("Dequeued: " + dequeue()); // Should print 20
        System.out.println("Dequeued: " + dequeue()); // Should print 30
        System.out.println("Dequeued: " + dequeue()); // Should print "Queue is empty"
    }
}
