package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class stackUsingDeque {

    static class Stack {
        Deque<Integer> deque = new ArrayDeque<Integer>();

        public void push(int data) {
            deque.addFirst(data);
        }

        public int pop() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {

        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());

    }
    
}
