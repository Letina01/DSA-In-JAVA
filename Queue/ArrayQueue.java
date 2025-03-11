package Queue;

public class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor to initialize the queue with a specific capacity
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue operation to add an element to the rear of the queue 
    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        rear = (rear + 1) % capacity; // Circular increment for rear
        queue[rear] = value;
        size++;
        return true;
    }

    // Dequeue operation to remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removedValue = queue[front];
        front = (front + 1) % capacity; // Circular increment for front
        size--;
        return removedValue;
    }

    // Get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Get the current size of the queue
    public int getSize() {
        return size;
    }
    //reverse a queue using recursion
    public void reverseQueue() {
        if (!isEmpty()) {
            int removedValue = dequeue();
            reverseQueue();
            enqueue(removedValue);
        }
    }
     // Function to print the queue.
     public void printQueue() {
        System.out.println(queue);
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        System.out.println("Front element: " + queue.peek()); // 10

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        System.out.println("Front element after dequeue: " + queue.peek()); // 20

        queue.enqueue(60); // Should add 60 at the rear, showing circular behavior

        System.out.println("Queue after enqueueing 60:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " "); // 20 30 40 50 60
        }
    }
}
