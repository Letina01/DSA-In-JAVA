package stack;

import java.util.Stack;

public class minStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int data) {
        stack.push(data);
        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1; // Return -1 if stack is empty
        }
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
        return top;
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1; // Return -1 if stack is empty
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1; // Return -1 if no minimum value exists
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        minStack s = new minStack();
        s.push(5);
        s.push(3);
        s.push(7);
        s.push(2);
        System.out.println("Peek: " + s.peek());    // Should print 2
        System.out.println("Min: " + s.getMin());  // Should print 2
        System.out.println("Pop: " + s.pop());    // Should remove 2
        System.out.println("Min: " + s.getMin()); // Should print 3
        System.out.println("Peek: " + s.peek());  // Should print 7
    }
}
