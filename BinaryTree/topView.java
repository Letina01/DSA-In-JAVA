package BinaryTree;

import java.util.*;

class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class topView {

    // Function to print the top view of the binary tree
    public static void TopView(Node root) {
        if (root == null) {
            return;
        }

        // Map to store the topmost node at each horizontal distance
        Map<Integer, Integer> topMap = new TreeMap<>();

        // Queue for level-order traversal with horizontal distance
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> curr = q.poll();
            Node currNode = curr.getKey();
            int hd = curr.getValue();

            // If the horizontal distance is not in the map, add it (top view)
            if (!topMap.containsKey(hd)) {
                topMap.put(hd, currNode.data);
            }

            // Add left and right children to the queue with updated horizontal distance
            if (currNode.left != null) {
                q.add(new Pair<>(currNode.left, hd - 1));
            }
            if (currNode.right != null) {
                q.add(new Pair<>(currNode.right, hd + 1));
            }
        }

        // Print the top view (nodes at the first encountered horizontal distance)
        for (int value : topMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Function to print the bottom view of the binary tree
    public static void bottomView(Node root) {
        if (root == null) {
            return;
        }

        // Map to store the bottommost node at each horizontal distance
        Map<Integer, Integer> bottomMap = new TreeMap<>();

        // Queue for level-order traversal with horizontal distance
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> curr = q.poll();
            Node currNode = curr.getKey();
            int hd = curr.getValue();

            // Always overwrite the node at this horizontal distance (bottom view)
            bottomMap.put(hd, currNode.data);

            // Add left and right children to the queue with updated horizontal distance
            if (currNode.left != null) {
                q.add(new Pair<>(currNode.left, hd - 1));
            }
            if (currNode.right != null) {
                q.add(new Pair<>(currNode.right, hd + 1));
            }
        }

        // Print the bottom view (nodes at the last encountered horizontal distance)
        for (int value : bottomMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Pair class to store node and its horizontal distance
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    // Driver code
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        // Call the topView method
        System.out.print("Top View: ");
        TopView(root);  // Output should be: 8 4 2 1 3 7

        // Call the bottomView method
        System.out.print("Bottom View: ");
        bottomView(root);  // Output should be: 8 4 5 1 6 7
    }
}
