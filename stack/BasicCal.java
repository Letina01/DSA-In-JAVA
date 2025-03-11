package stack;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int result = 0;  // This will store the final result
        int sign = 1;    // 1 means positive, -1 means negative
        int currentNumber = 0; // To handle multi-digit numbers
        
        // Use a stack to handle parentheses
        Stack<Integer> stack = new Stack<>();
        
        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // If it's a digit, form the current number
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }
            
            // If we encounter a '+' or '-', calculate the previous number
            if (c == '+' || c == '-' || i == s.length() - 1) {
                result += sign * currentNumber;  // Apply the current sign to the current number
                currentNumber = 0;  // Reset the current number
                
                // Update the sign for the next number
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                }
            }
            
            // If we encounter a '(', push the result and sign onto the stack and reset them
            if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            
            // If we encounter a ')', pop the result and sign from the stack and update the result
            if (c == ')') {
                result += sign * currentNumber;  // Apply the current sign to the current number
                currentNumber = 0;  // Reset the current number
                
                result *= stack.pop();  // Pop the sign
                result += stack.pop();  // Pop the previous result
            }
        }
        
        // After the loop, there might still be a number left to add to the result
        result += sign * currentNumber;
        
        return result;
    }
}
