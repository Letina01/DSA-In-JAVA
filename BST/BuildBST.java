package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildBST {

    // Node class should be outside the BuildBST class
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to build a balanced BST from a sorted array
    public static Node buildTree(int[] arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(arr[mid]);
        root.left = buildTree(arr, si, mid - 1);
        root.right = buildTree(arr, mid + 1, ei);
        return root;
    }

    // In-order traversal of the BST to print elements in sorted order
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left); // Left subtree
        System.out.print(root.data + " ");
        inOrder(root.right); // Right subtree
    }

    // search in bst
    public static Node search(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data == key) {
            return root;
        }
        if (root.data > key) {
            return search(root.left, key);
        }
        return search(root.right, key);
    }

    // delete a node in bst
    public static Node deleteNode(Node root, int key) {
        if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.data > key) {
            root.left = deleteNode(root.left, key);

        }

        else {
            // case1
            if (root.left == null && root.right == null) {
                return null;
            }
            // case2
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } // case3
            Node IS = inorderSuccessor(root.left);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // print in Range
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        } else if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
    }

    // root to leaf path
    public static void printpath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("NULL");
    }

    public static void rootToLeafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printpath(path);
        }
        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);
        path.remove(path.size() - 1);

    }

    // valid bst
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // mirror of bst
    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // sorted array to balanced bst
    public static Node CreateBalancedBST(int[] arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(arr[mid]);
        root.left = CreateBalancedBST(arr, si, mid - 1);
        root.right = CreateBalancedBST(arr, mid + 1, ei);
        return root;
    }

    // covert bst to balanced bst
    // Method to perform inorder traversal of BST and store the elements in a list
    public static void getInorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    // Method to create a balanced BST from the sorted array (inorder list)
    public static Node createBST(ArrayList<Integer> arr, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, si, mid - 1);
        root.right = createBST(arr, mid + 1, ei);
        return root;
    }

    // Method to convert a given BST to a balanced BST
    public static Node convertToBalancedBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list); // Get inorder traversal of BST
        root = createBST(list, 0, list.size() - 1); // Create balanced BST from inorder list
        return root;
    }

    // size of largest bst in bt
    class BSTInfo {
        int size;
        boolean isBST;
        int min;
        int max;

        public BSTInfo(int size, boolean isBST, int min, int max) {
            this.size = size;
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public class LargestBSTInBT {

        // Helper method to perform post-order traversal and find the largest BST
        public static BSTInfo largestBSTSubtree(Node root) {
            if (root == null) {
                return new BSTInfo(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            // Recursively get the BST info for the left and right subtrees
            BSTInfo left = largestBSTSubtree(root.left);
            BSTInfo right = largestBSTSubtree(root.right);

            // Check if the current node is part of a valid BST
            if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
                // If the current subtree is a BST, calculate its size
                int size = left.size + right.size + 1;
                int min = Math.min(root.data, left.min);
                int max = Math.max(root.data, right.max);
                return new BSTInfo(size, true, min, max);
            } else {
                // If not a BST, return the size of the largest BST in the left or right subtree
                return new BSTInfo(Math.max(left.size, right.size), false, 0, 0);
            }
        }

        // Method to find the size of the largest BST in the binary tree
        public static int largestBSTSize(Node root) {
            return largestBSTSubtree(root).size;
        }

        // merge two bst
        public static void getInorder(Node root, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }
            getInorder(root.left, list);
            list.add(root.data);
            getInorder(root.right, list);

        }

        public static Node createBST(ArrayList<Integer> arr, int si, int ei) {
            if (si > ei) {
                return null;
            }
            int mid = (si + ei) / 2;
            Node root = new Node(arr.get(mid));
            root.left = createBST(arr, si, mid - 1);
            root.right = createBST(arr, mid + 1, ei);
            return root;
        }

        public static Node merge(Node root1, Node root2) {
            // step1
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            getInorder(root1, list1);
            getInorder(root2, list2);
            // step2
            int i = 0;
            int j = 0;
            ArrayList<Integer> mergedList = new ArrayList<>();
            while (i < list1.size() && j < list2.size()) {
                if (list1.get(i) < list2.get(j)) {
                    mergedList.add(list1.get(i));
                    i++;
                } else {
                    mergedList.add(list2.get(j));
                    j++;
                }
            }
            while (i < list1.size()) {
                mergedList.add(list1.get(i));
                i++;
            }
            while (j < list2.size()) {
                mergedList.add(list2.get(j));
                j++;
            }
            // step3
            return createBST(mergedList, 0, mergedList.size() - 1);
        }

        // right view
        public static List<Integer> rightView(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root); // Start with the root node
            while (!q.isEmpty()) {
                int size = q.size(); // Get the number of nodes at the current level
                for (int i = 0; i < size; i++) {
                    Node curr = q.remove(); // Process each node in the level
                    if (i == size - 1) { // If it's the last node in the level
                        System.out.print(curr.data + " "); // Print its data
                    }
                    if (curr.left != null) { // Add left child to the queue if it exists
                        q.add(curr.left);
                    }
                    if (curr.right != null) { // Add right child to the queue if it exists
                        q.add(curr.right);
                    }
                }
            }
            return result;

        }

        // averge of level in binary tree
        public static double averageOfLevels(Node root) {
            double sum = 0;
            int count = 0;
            Queue<Node> q = new LinkedList<>();
            q.add(root); // Start with the root node
            while (!q.isEmpty()) {
                int size = q.size(); // Get the number of nodes at the current level
                for (int i = 0; i < size; i++) {
                    Node curr = q.remove(); // Process each node in the level
                    sum += curr.data; // Add the node's data to the sum
                    count++; // Increment the count
                    if (curr.left != null) { // Add left child to the queue if it exists
                        q.add(curr.left);
                    }
                    if (curr.right != null) { // Add right child to the queue if it exists
                        q.add(curr.right);
                    }
                }
            }
            return sum / count;
        }

        // kth smallest element
        public int kthSmallest(Node root, int k) {
            inorder(root, k);
            return result;
        }

        int result = -1;
        int count = 0;

        private void inorder(Node node, int k) {
            if (node == null) {
                return;
            }
            inorder(node.left, k);
            count++;
            if (count == k) {
                result = node.data;
                return;
            }
            inorder(node.right, k);

        }

    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3, 4, 2, 6, 8, 7, 9, 10 };

        // Sort the array before building the BST
        java.util.Arrays.sort(arr);

        int n = arr.length;
        Node root = buildTree(arr, 0, n - 1);
        inOrder(root); // Print the in-order traversal of the BST

    }

}
