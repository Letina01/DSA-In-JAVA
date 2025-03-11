package Queue;

public class circularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor to initialize the queue with a specific capacity
    public circularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = -1;
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
        if (isEmpty()) {
            front = 0; // Initialize front when adding the first element
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
        if (front == rear) { // If the queue becomes empty after dequeue
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity; // Circular increment for front
        }
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

    public static void main(String[] args) {
        circularQueue circularQueue = new circularQueue(5);

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        circularQueue.enqueue(40);
        circularQueue.enqueue(50);

        System.out.println("Front element: " + circularQueue.peek()); // 10

        System.out.println("Dequeued: " + circularQueue.dequeue()); // 10
        System.out.println("Front element after dequeue: " + circularQueue.peek()); // 20

        circularQueue.enqueue(60); // Should add 60 at the rear, showing circular behavior

        System.out.println("Queue after enqueueing 60:");
        while (!circularQueue.isEmpty()) {
            System.out.print(circularQueue.dequeue() + " "); // 20 30 40 50 60
        }
    }
}
