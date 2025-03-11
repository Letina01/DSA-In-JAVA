package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.tree.TreeNode;

import BinaryTree.topView.Pair;

public class buildPreorderTree {
    static class Node{
        int data;
        Node left;
        Node right;
         Node(int data) {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class binaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
            
        }
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void postorder(Node root){
            if(root==null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void levelorder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                   System.out.println();
                    if(!q.isEmpty()){
                       break;
                    }else{
                        q.add(null);
                    }
                    }else{
                        System.out.print(currNode.data+" ");
                        if(currNode.left!=null){
                            q.add(currNode.left);
                        }
                        if(currNode.right!=null){
                            q.add(currNode.right);
                        }
                    }
                }
               
        }
        public static int heightOfTree(Node root){
            if(root==null){
                return 0;
            }
            int lh=heightOfTree(root.left);
            int rh=heightOfTree(root.right);
            return Math.max(lh, rh)+1;
        }
        public static int countNodes(Node root){
            if(root==null){
                return 0;
            }
            int lh=countNodes(root.left);
            int rh=countNodes(root.right);
            return lh+rh+1;
        }
        public static int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }
            int lh=sumOfNodes(root.left);
            int rh=sumOfNodes(root.right);
            return lh+rh+root.data;
        }
        public static int diameterOfTree(Node root){
            if(root==null){
                return 0;
            }
            int lh=heightOfTree(root.left);
            int rh=heightOfTree(root.right);
            int ld=diameterOfTree(root.left);
            int rd=diameterOfTree(root.right);
            return Math.max(lh+rh+1, Math.max(ld, rd));
        }
        //check subtree
        public static boolean isSubtree(Node root1, Node root2) {
            if (root2 == null) {
                return true; // An empty tree is always a subtree.
            }
            if (root1 == null) {
                return false; // Non-empty tree can't be a subtree of a null tree.
            }
            
            // Check if the trees rooted at root1 and root2 are identical
            if (isIdentical(root1, root2)) {
                return true;
            }
            
            // Recursively check the left and right subtrees of root1
            return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
        }
        
        // Helper method to check if two trees are identical
        public static boolean isIdentical(Node root1, Node root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            
            // Check if current nodes match and recursively check left and right subtrees
            return (root1.data == root2.data) && 
                   isIdentical(root1.left, root2.left) && 
                   isIdentical(root1.right, root2.right);
        }
        //kth level of a tree
        public static void printKthLevel(Node root, int k,int level) {
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data + " ");
                return;
            }
            printKthLevel(root.left, k, level + 1);
            printKthLevel(root.right, k, level + 1);

            return;
            }
            //last common ancestor
            public static boolean getpath(Node root, int n1, ArrayList<Node> path) {
                if (root == null) {
                    return false;
                }
                path.add(root);
                if (root.data == n1) {
                    return true;
                }
              boolean left =  getpath(root.left, n1, path);
              boolean right = getpath(root.right, n1, path);
              if (left || right) {
                return true ;
                }
              path.remove(path.size() - 1);
              return false;
        
            }
            public static Node lca(Node root, int n1, int n2) {
                if (root == null) {
                    return null;
                }
               ArrayList<Node> path1 = new ArrayList<>();
                ArrayList<Node> path2 = new ArrayList<>();
                getpath(root, n1, path1);
                getpath(root, n2, path2);
                //lca
                int i = 0;
                for (i = 0; i < path1.size() && i < path2.size(); i++) {
                    if (path1.get(i) != path2.get(i)) {
                        break;
                    }
                }
                Node lca=path1.get(i-1);
                return lca;
            }
            // min distance between two nodes
            public static int minDistance(Node root, int n1, int n2) {
                Node lca = lca(root, n1, n2);
                int d1 = distance(root, n1, lca);
                int d2 = distance(root, n2, lca);
                return d1 + d2;
            }
            public static int distance(Node root, int n, Node lca) {
                if (root == null) {
                    return 0;
                }
                if (root.data == n) {
                    return 0;
                }
                int dl = distance(root.left, n, lca);//left
                int dr = distance(root.right, n, lca);//right

              if(dl==-1 && dr==-1){
                  return -1;
              }
              if(dl==-1){
                  return dr+1;
              }
              if(dr==-1){
                  return dl+1;
              }
              return Math.min(dl, dr) + 1;
            }
            //kth asector of node
            public static int kthAncestor(Node root, int n, int k) {
                if (root.data == n) {
                    return 0;
                }
                int leftDist=kthAncestor(root.left, n, k);
                int rightDist=kthAncestor(root.right, n, k);
                if (leftDist == -1 && rightDist == -1) {
                    return -1;
                }
                int max=Math.max(leftDist,rightDist);
                if(max+1==k){
                    System.out.println(root.data);
                }
                return max+1;
            }

    //Transfor to sum tree
    public static Node sumTree(Node root){
        if(root==null){
        return root;
        }
        root.left=sumTree(root.left);
        root.right=sumTree(root.right);
        root.data=root.data+sumTree(root.left).data+sumTree(root.right).data;
        return root;
    }
    //max depth of binary tree
    public static int maxDepth(Node root){
        if(root==null){
        return 0;
        }
        int lh=maxDepth(root.left);
        int rh=maxDepth(root.right);
        return Math.max(lh, rh)+1;
    }
    //same tree
    class Solution {
    public boolean isSameTree(Node p, Node q) {
        // Base case: both nodes are null
        if (p == null && q == null) {
            return true;
        }
        // One of the nodes is null, or values are different
        if (p == null || q == null || p.data != q.data) {
            return false;
        }
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    //invert binary tree
    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
   //symmetric tree
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public static boolean isMirror(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.data == right.data) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    //path sum
    public boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.data == sum) {
            return true;
        }
        int remainingSum = sum - root.data;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
    //count complete tree nodes
    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    //lowest common ancestor
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        //result
        if(left==null){
            return right;
        }else if(right==null){
            return left;
        }else{
            return root;
        }
    }
    //maxpathsum
    public class BinaryTree {
        private int maxSum = Integer.MIN_VALUE;
    
        public int maxPathSum(Node root) {
            if (root == null) {
                return 0;
            }
            calculateMaxPath(root);
            return maxSum;
        }
    
        // Helper function to calculate the maximum path sum
        private int calculateMaxPath(Node node) {
            if (node == null) {
                return 0;
            }
    
            // Recursively calculate the maximum path sum for left and right subtrees
            int leftSum = Math.max(0, calculateMaxPath(node.left)); // Ignore negative paths
            int rightSum = Math.max(0, calculateMaxPath(node.right)); // Ignore negative paths
    
            // Calculate the maximum path sum passing through the current node
            int currentPathSum = leftSum + rightSum + node.data;
    
            // Update the global maxSum if the current path sum is greater
            maxSum = Math.max(maxSum, currentPathSum);
    
            // Return the maximum path sum of one branch (left or right) + current node
            return Math.max(leftSum, rightSum) + node.data;
        }
    }
    //zigzag traversal
    public class BinaryTree {
        public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (leftToRight) {
                    level.add(node.data);
                } else {    
                    level.add(0, node.data);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;  

     }
    }
  }
  //boundary level order traversal
  public class BinaryTree {
    public List<Integer> boundaryLevelOrder(Node root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
          return result;
      }
      result.add(root.data);
      addLeftBoundary(root.left, result);
      addLeaves(root, result);
      addRightBoundary(root.right, result);
      return result;
      }
    private void addLeftBoundary(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            result.add(root.data);
            addLeftBoundary(root.left, result);
        } else if (root.right != null) {
            result.add(root.data);
            addLeftBoundary(root.right, result);
        }
    }
    private void addRightBoundary(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            addRightBoundary(root.right, result);
            result.add(root.data);
        } else if (root.left != null) {
            addRightBoundary(root.left, result);
            result.add(root.data);
        }
    }
    private void addLeaves(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        addLeaves(root.left, result);
        if (root.left == null && root.right == null) {
            result.add(root.data);
        }
        addLeaves(root.right, result);
    }
  }
  //vertical order traversal
  public class BinaryTree {
    public List<List<Integer>> verticalOrder(Node root) {
      if (root == null) {
          return new ArrayList<>();
      }
      Map<Integer, List<Integer>> map = new HashMap<>();
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      int min = 0;
      int max = 0;
      while (!queue.isEmpty()) {
          Node node = queue.poll();
          min = Math.min(min, node.data);
          max = Math.max(max, node.data);
          if (node.left != null) {
              queue.add(node.left);
          }
          if (node.right != null) {
              queue.add(node.right);
          }
      }
      for (int i = min; i <= max; i++) {
          map.put(i, new ArrayList<>());
      }
      queue.add(root);
      while (!queue.isEmpty()) {
          Node node = queue.poll();
          int index = node.data - min;
          map.get(index).add(node.data);
          if (node.left != null) {
              queue.add(node.left);
          }
          if (node.right != null) {
              queue.add(node.right);
          }
      }
      List<List<Integer>> result = new ArrayList<>();
      for (int i = min; i <= max; i++) {
          result.add(map.get(i));
      }
      return result;
  }
  }
  //top view
  static class info{
    Node data;
    int hd;
    public info(Node data, int hd) {
        this.data = data;
        this.hd = hd;
  }
  public static void TopView(Node root) {
    if (root == null) {
        return;
    }

    // Map to store the topmost node at each horizontal distance
    Queue<info> q = new LinkedList<>();
    HashMap<Integer, Node> topMap = new HashMap<>();
    int min=0;
    int max=0;
    q.add(new info(root, 0));
    q.add(null);
    while (!q.isEmpty()) {
        info curr = q.remove();
        if (curr == null) {
            if (q.isEmpty()) {
                break;
            }
            else {
                q.add(null);
            }
            } 
            if(topMap.containsKey(curr.hd)) {
                topMap.put(curr.hd, curr.data);
            }
            if (curr.data.left != null) {
                q.add(new info(curr.data.left, curr.hd - 1));
                min=Math.min(min, curr.hd-1);
            }
            if (curr.data.right != null) {
                q.add(new info(curr.data.right, curr.hd + 1));
                max=Math.max(max, curr.hd+1);

            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(topMap.get(i).data + " ");
        }
        System.out.println();
    }
    //bottom view
    public static void BottomView(Node root) {
        if (root == null) {
            return;
        }
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> bottomMap = new HashMap<>();
        int min=0;
        int max=0;
        q.add(new info(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
                else {
                    q.add(null);
                }
            }
            if (bottomMap.containsKey(curr.hd)) {
                bottomMap.put(curr.hd, curr.data);
            }
            if (curr.data.left != null) {
                q.add(new info(curr.data.left, curr.hd - 1));
                min=Math.min(min, curr.hd-1);
            }
            if (curr.data.right != null) {
                q.add(new info(curr.data.right, curr.hd + 1));
                max=Math.max(max, curr.hd+1);
            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(bottomMap.get(i).data + " ");
        }
        System.out.println();
    }
    //right/left view
    public static void LeftView(Node root) {
        if (root == null) {
            return;
        }
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> leftMap = new HashMap<>();
        int min=0;
        int max=0;
        q.add(new info(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                break;
                }
                else {
                    q.add(null);
                }
                }
                if (leftMap.containsKey(curr.hd)) {
                    leftMap.put(curr.hd, curr.data);
                }
                if (curr.data.left != null) {
                    q.add(new info(curr.data.left, curr.hd + 1));
                    max=Math.max(max, curr.hd+1);
                }
                if (curr.data.right != null) {
                    q.add(new info(curr.data.right, curr.hd + 1));
                    max=Math.max(max, curr.hd+1);
                }
                }
                for (int i = min; i <= max; i++) {
                    System.out.print(leftMap.get(i).data + " ");
                }
                }
            }
            //root to leaf path
            public static ArrayList<ArrayList<Integer>> Paths(Node root) {
                // code here
                if(root==null){
                    return new ArrayList<>();
                }
                ArrayList<ArrayList<Integer>> res=new ArrayList<>();
                ArrayList<Integer> path=new ArrayList<>();
                path.add(root.data);
                pathres(root,path,res);
                return res;
            }
            public static void pathres(Node root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>>res){
                if(root==null){
                    return;
                }
                if(root.left==null && root.right==null){
                    res.add(new ArrayList<>(path));
                    return;
                }
                if(root.left!=null){
                    path.add(root.left.data);
                    pathres(root.left,path,res);
                    path.remove(path.size()-1);
                }
                if(root.right!=null){
                    path.add(root.right.data);
                    pathres(root.right,path,res);
                    path.remove(path.size()-1);
                }
            }
            //width of binary tree
                public static class info {
                    TreeNode data;
                    int index;
            
                    public info(TreeNode data, int index) {
                        this.data = data;
                        this.index = index;
                    }
                }
            
                public int widthOfBinaryTree(TreeNode root) {
                    if (root == null) {
                        return 0; // Edge case: Empty tree
                    }
            
                    Queue<info> q = new LinkedList<>();
                    q.add(new info(root, 0)); // Initialize the queue with root and index 0
                    int maxWidth = 0;
            
                    while (!q.isEmpty()) {
                        int size = q.size();
                        int min = q.peek().index; // Get the index of the first node in the current level
                        int first = 0, last = 0; // Initialize first and last for each level
            
                        for (int i = 0; i < size; i++) {
                            info temp = q.poll(); // Retrieve and remove the front of the queue
                            int currentIndex = temp.index - min; // Normalize the index to prevent overflow
            
                            if (i == 0) {
                                first = currentIndex; // First index in the current level
                            }
                            if (i == size - 1) {
                                last = currentIndex; // Last index in the current level
                            }
            
                            // Add left and right children with their respective indices
                            if (temp.data.left != null) {
                                q.add(new info(temp.data.left, 2 * currentIndex));
                            }
                            if (temp.data.right != null) {
                                q.add(new info(temp.data.right, 2 * currentIndex + 1));
                            }
                        }
            
                        // Update the maximum width
                        maxWidth = Math.max(maxWidth, last - first + 1);
                    }
            
                    return maxWidth;
                }
    //all nodes distance k in binary tree
     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null){
            return new ArrayList<>();
        }
       Map<TreeNode,TreeNode> parentMap=new HashMap<>();
       buildParentMap(root,null,parentMap);
       Queue<TreeNode> q=new LinkedList<>();
       Set<TreeNode> visited=new HashSet<>();
       q.add(target);
       visited.add(target);
       int currDist=0;
       while(!q.isEmpty()){
        if(currDist==k){
            List<Integer> result =new ArrayList<>();
            for(TreeNode node: q ){
                result.add(node.val);
            }
            return result;
        }
        int size=q.size();
        for(int i=0;i<size;i++){
            TreeNode node=q.poll();
             if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }
                if (parentMap.get(node) != null && !visited.contains(parentMap.get(node))) {
                    q.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            currDist++;
        }
        return new ArrayList<>();
}
 private void buildParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }
        parentMap.put(node, parent);
        buildParentMap(node.left, node, parentMap);
        buildParentMap(node.right, node, parentMap);
    }
    //kth smallest element
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
        }
        private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
    }  
    
}
    public static void main(String[] args) {
        int nodes[] = {1, 2,4,-1,-1,5,-1,-1,3,-1,-1,6,-1,-1};
        binaryTree tree=new binaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println();
        tree.preorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.levelorder(root);
        System.out.println();
        System.out.println(tree.heightOfTree(root));
        System.out.println(tree.countNodes(root));
        System.out.println(tree.sumOfNodes(root));
        System.out.println(tree.diameterOfTree(root));
       
        System.out.println();
        System.out.println(tree.isSubtree(root, root));
        System.out.println();
        tree.printKthLevel(root, 2, 1);
        

        
        }

    
}
