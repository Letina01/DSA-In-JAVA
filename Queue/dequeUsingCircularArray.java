package Queue;


    public class dequeUsingCircularArray{
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the deque with a specific capacity
    public dequeUsingCircularArray(int capacity) {
        this.capacity = capacity;
        this.deque = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add an element at the front
    public boolean insertFront(int value) {
        if (isFull()) {
            System.out.println("Deque is full");
            return false;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity; // Circular decrement
        }
        deque[front] = value;
        size++;
        return true;
    }

    // Add an element at the rear
    public boolean insertLast(int value) {
        if (isFull()) {
            System.out.println("Deque is full");
            return false;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity; // Circular increment
        }
        deque[rear] = value;
        size++;
        return true;
    }

    // Delete an element from the front
    public boolean deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return false;
        }
        if (front == rear) { // Only one element
            front = rear = -1;
        } else {
            front = (front + 1) % capacity; // Circular increment
        }
        size--;
        return true;
    }

    // Delete an element from the rear
    public boolean deleteLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return false;
        }
        if (front == rear) { // Only one element
            front = rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity; // Circular decrement
        }
        size--;
        return true;
    }

    // Get the front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return deque[front];
    }

    // Get the rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return deque[rear];
    }

    public static void main(String[] args) {
        dequeUsingCircularArray deque = new dequeUsingCircularArray(5);
        
        deque.insertLast(10);
        deque.insertLast(20);
        deque.insertFront(5);
        deque.insertFront(3);
        System.out.println("Front element: " + deque.getFront()); // 3
        System.out.println("Rear element: " + deque.getRear()); // 20
        
        deque.deleteFront();
        System.out.println("Front element after deletion: " + deque.getFront()); // 5
        
        deque.deleteLast();
        System.out.println("Rear element after deletion: " + deque.getRear()); // 10
    }
}


