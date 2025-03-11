package stack;

import java.util.Stack;
import java.util.Queue;


public class stackUsingLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {

        static Node head=null;
        //empty
        public boolean isEmpty() {

            return head == null;
        }

        //push
        public void push(int data) {
            if(isEmpty()){
                head = new Node(data);
            }
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;

        }

        //pop

        public int pop() {
            if(isEmpty()){
                return -1;
            }
            int top = head.data;

            head = head.next;

            return top;
        }
        //peek

        public int peek() {
            if(isEmpty()){
                return -1;
            }

            return head.data;

        }
        //push at bottom

        public void pushAtBottom(int data) {

            if(isEmpty()){
                head = new Node(data);
            }

            Node newNode = new Node(data);

            newNode.next = head;

            head = newNode;

        }
        //reverse 
        public void reverse() {

            if(isEmpty()){
                return;
            }

            Node curr = head;

            Node prev = null;

            while(curr!=null){

                Node next = curr.next;

                curr.next = prev;

                prev = curr;

                curr = next;
            }

            head = prev;
        }

    }
    //reverse a string using stack
    public static String reverseString(String str) {

        //Stack<Character> st = new Stack<>();

        Stack st = new Stack();

        for(int i=0;i<str.length();i++){

            st.push(str.charAt(i));

        }

        String ans = "";

        for(int i=0;i<str.length();i++){

            ans += st.pop();

        }

        return ans;

    }
    //reverse individual words

    public static String reverseWord(String str) {

        Stack st = new Stack();

        for(int i=0;i<str.length();i++){

            if(str.charAt(i) == ' '){

                while(!st.isEmpty()){

                    System.out.print(st.pop());

                }

                System.out.print(" ");

            }else{

                st.push(str.charAt(i));

            }

        }

        while(!st.isEmpty()){

            System.out.print(st.pop());

        }

        return "";

    }
    //reverse stack using queue

   /* public static void reverseStack(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();

        // Move all elements from the stack to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Move all elements back from the queue to the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
    }*/ 
    //reverse array using stack

  /*  public static void reverseArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // Push all elements of the array onto the stack
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        // Pop elements from the stack back into the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }*/ 
    // Function to delete the middle element from the stack
    /*public static void deleteMiddle(Stack<Integer> stack, int size, int curr) {

        // Base case: when we've reached the middle of the stack
        if (curr == size / 2) {
            stack.pop(); // Remove the middle element
            return;
        }

        // Pop the top element and hold it in a temporary variable
        int temp = stack.pop();

        // Recursive call to process the next element
        deleteMiddle(stack, size, curr + 1);

        // Push the element back after the middle element has been deleted
        stack.push(temp);
    }*/
//next grater element

/*public class NGEExample {
    public static int[] nextLargerElement(int[] arr, int n) {
        // Create a stack to store elements for which we need to find the NGE
        Stack<Integer> st = new Stack<>();
        // Create a result array to store the NGE for each element
        int[] result = new int[n];

        // Traverse the array from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            // If the stack is empty, there's no greater element
            if (st.isEmpty()) {
                result[i] = -1;
            } else if (!st.isEmpty() && st.peek() > arr[i]) {
                // If the top of the stack is greater than the current element
                result[i] = st.peek();
            } else {
                // Pop elements until we find a greater element
                while (!st.isEmpty() && st.peek() <= arr[i]) {
                    st.pop();
                }
                // After popping, check if the stack is empty
                result[i] = (st.isEmpty()) ? -1 : st.peek();
            }
            // Push the current element onto the stack
            st.push(arr[i]);
        }

        return result; // Return the array with next larger elements
    }

    // Example usage
    public static void main(String[] args) {
        int arr[] = {4, 5, 2, 10, 8};
        int n = arr.length;
        int[] nextLarger = nextLargerElement(arr, n);

        // Print the results
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " -- " + nextLarger[i]);
        }
    }
}*/
//nearest smallest
/*static List<Integer> leftSmaller(int n, int a[])
{
    //code here
    Stack<Integer> s=new Stack<>();
    List<Integer> result=new ArrayList<>();
    for(int i=0;i<n;i++){
        while(!s.isEmpty() && s.peek()>=a[i]){
            s.pop();
        }
       if(s.isEmpty()){
           result.add(-1);
       }else{
           result.add(s.peek());
       }
       s.push(a[i]);
    }
    return result;
}
}*/
//the celebrity problem using m*n matrix
/*public class Solution {

    // Function to find if there is a celebrity.
    static int celebrity(int matrix[][], int n) {
        Stack<Integer> s = new Stack<>();

        // Push all people into the stack.
        for (int i = 0; i < n; i++) {
            s.push(i);
        }

        // Finding a potential celebrity
        while (s.size() > 1) {
            int i = s.pop();
            int j = s.pop();

            // If i knows j, then i can't be a celebrity, but j might be.
            if (matrix[i][j] == 1) {
                s.push(j);
            } else {
                // If i doesn't know j, then j can't be a celebrity, but i might be.
                s.push(i);
            }
        }

        // Potential celebrity
        int i = s.pop();

        // Verification: i should not know anyone, and everyone should know i.
        for (int j = 0; j < n; j++) {
            // Skip the check when j == i.
            if (i != j && (matrix[i][j] == 1 || matrix[j][i] == 0)) {
                return -1;
            }
        }

        return i;
    }
}*/
//evaluate postfix expression
/* static int evaluatePostfix(String exp)
    {
        // Create a stack
        Stack<Integer> stack = new Stack<>();
 
        // Scan all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
 
            // If the scanned character is an operand
            // (number here), push it to the stack.
            if (Character.isDigit(c))
                stack.push(c - '0');
 
            //  If the scanned character is an operator, pop
            //  two elements from stack apply the operator
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
 
                switch (c) {
                case '+':
                    stack.push(val2 + val1);
                    break;
                case '-':
                    stack.push(val2 - val1);
                    break;
                case '/':
                    stack.push(val2 / val1);
                    break;
                case '*':
                    stack.push(val2 * val1);
                    break;
                }
            }
        }
        return stack.pop();
    }
}*/
//infix to postfix
/*static String infixToPostfix(String exp)
    {
        // Create a stack to store operators.
        Stack<Character> stack = new Stack<>();
 
        // Initialize result
        String result = "";
 
        // Traverse expression
        for (int i = 0; i < exp.length(); ++i)
        {
            char c = exp.charAt(i);
 
            // If the scanned character is an operand, add it to output
            if (Character.isLetterOrDigit(c))
                result += c;
 
            // If the scanned character is an '(', push it to stack
            else if (c == '(')
                stack.push(c);
 
            // If the scanned character is an ')', pop and output from the stack
            // until an '(' is encountered
            else if (c == ')')
            {
                while (stack.peek() != '(')
                    result += stack.pop();
                stack.pop();
            }
 
            // An operator is encountered
            else
            {
                while (!stack.isEmpty()
                       && stack.peek() != '('
                       && Prec(c) <= Prec(stack.peek()))
                    result += stack.pop();
                stack.push(c);
            }
        }
 
        // pop all the remaining elements from the stack
        while (!stack.isEmpty())
            result += stack.pop();
 
        return result;
    }
 
    // Returns true if 'op1' has higher or same precedence as 'op2'
    // operator
    static int Prec(char op1)
    {
        if (op1 == '*' || op1 == '/')
            return 3;
        else if (op1 == '+' || op1 == '-')
            return 2;
        else
            return 1;
    }

    // Driver code
    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(
            "Prefix : " + infixToPostfix(exp));
    }*/

//longest vALID parenthesis
/*public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base index for the initial valid substring
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i); // Push index of '('
            } else {
                stack.pop(); // Pop for a valid '()' pair or invalid ')'

                if (stack.isEmpty()) {
                    stack.push(i); // Push current index as the new base
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}*/

    

    public static void main(String[] args) {

        Stack st = new Stack();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st.peek());

        System.out.println(st.pop());

        System.out.println(st.peek());

        st.pushAtBottom(6);

        System.out.println(st.peek());

        st.reverse();

        System.out.println(st.peek());


    }
    
}
