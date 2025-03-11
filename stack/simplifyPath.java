package stack;

import java.util.Stack;

public class simplifyPath {
    public static String SimplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        
        // Process each component of the path
        for (int i = 0; i < paths.length; i++) {
            String p = paths[i];
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Go back one directory
                }
            } else if (!p.equals(".") && !p.equals("")) {
                stack.push(p); // Add valid directory
            }
        }

        // Build the canonical path
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop()); // Prepend each directory
        }

        // If the stack was empty, return root "/"
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
