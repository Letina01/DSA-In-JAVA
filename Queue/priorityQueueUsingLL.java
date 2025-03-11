package Queue;
class Node {
    int data;
    int priority;
    Node next;

    // Constructor
    public Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}

public class priorityQueueUsingLL {
    private Node head;

    // Insert a new node into the priority queue
    public void insert(int data, int priority) {
        Node newNode = new Node(data, priority);

        // If the list is empty or the new node has higher priority than the head
        if (head == null || priority > head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            // Traverse the list and find the position to insert the new node
            Node current = head;
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Remove and return the highest priority element
    public int remove() {
        if (head == null) {
            throw new RuntimeException("Priority queue is empty.");
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Print the priority queue (for debugging)
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + ", priority: " + current.priority + "] -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        priorityQueueUsingLL pq = new priorityQueueUsingLL();
        
        pq.insert(10, 2);
        pq.insert(20, 1);
        pq.insert(15, 3);

        pq.display(); // Display the priority queue

        System.out.println("Removed: " + pq.remove());
        pq.display(); // Display after removal
    }
}

