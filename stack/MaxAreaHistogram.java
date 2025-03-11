package stack;

import java.util.Stack;

// Max area in histogram
public class MaxAreaHistogram {

    public static int maxArea(int[] height) {

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {

            // Process and pop stack if the current height is smaller than the height of the bar at the stack's top
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int index = stack.pop();
                int h = height[index]; // Height of the bar
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Width of the area
                int area = h * width;
                maxArea = Math.max(maxArea, area);
            }

            // Push the current bar to the stack
            stack.push(i);
        }

        // Process the remaining bars in the stack
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int h = height[index]; // Height of the bar
            int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1; // Width of the area
            int area = h * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = { 2, 1, 5, 6, 2, 3 };
        System.out.println("Maximum area in histogram: " + maxArea(height));  // Should print the maximum area, which is 10
    }
}
