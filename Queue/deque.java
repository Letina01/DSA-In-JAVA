package Queue;

import java.util.*;

public class deque {


    public static void main(String[] args) {

        // Create an empty deque
        Deque<Integer> deque = new LinkedList<>();

        // Add elements to the deque
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addLast(5);
        System.out.println("first element "+deque.getFirst() );
        System.out.println("last element "+deque.getLast() );
      
      
        // Print the deque
        System.out.println(deque);

        // Remove elements from the deque
        deque.removeFirst();
        deque.removeLast();

        // Print the deque
        System.out.println(deque);
    }

    public static void addLast(int data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLast'");
    }

    public static int removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    public static int getFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirst'");
    }
    
}
