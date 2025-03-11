package LinkedList;

public class linkedlist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Add middle
    public void addMiddle(int data, int index) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        for (int i = 1; i < index - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Print linked list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Remove first node
    public int removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        int val = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return val;
    }

    // Remove last node
    public int removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        if (head == tail) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }
    //search

    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    //seacrh using recursion
    public boolean searchRec(Node head,int key){
        if(head==null){
            return false;
        }
        if(head.data==key){
            return true;
        }
        return searchRec(head.next,key);
    }
    //reverse
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    //remove nthe node from end
    public void removeNthFromEnd(int n){
        //calulate size of linked list
        int size = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(n==size){
            head = head.next;//remove first
            return;
        }
        //size-1
        int i=1;
        int iToFind=size-n;
        Node prev = head;
        while(i!=iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
       
    }
    //check if linkedlist is plaindrom or not
    public boolean isPalindrome(){
        if(head==null || head.next==null){
            return true;
            
        }
        Node slow = head;
        Node fast = head;
        //find middle
        while(fast!=null && fast.next!=null){//even odd case
            slow = slow.next;//+1
            fast = fast.next.next;//+2 return slow, solw is the middle
        }
        //reverse 2nd half
        Node prev = null;
        Node curr = slow;//mid node
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //check 1st half and 2nd half is equal or not

        Node right = prev;
        Node left = head;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    //check loop
    public static boolean Checkloop(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    //remove a cycle
    public static void removeCycle(){
        //detect cyle
        Node slow = head;
        Node fast = head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle = true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null;//last node
        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle
        prev.next = null;
       
    }
    //find mid
    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //merge
    public static Node merge(Node left, Node right){
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next = left;
                left = left.next;
            }else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if(left!=null){
            temp.next = left;
        }
        if(right!=null){
            temp.next = right;
        }
        return dummy.next;
    }
    //merge sort
    public static Node mergeSort(Node head){
        //base case
        if(head==null || head.next==null){
            return head;
        }
        //find mid
        Node mid = findMid(head);
        //divide
        Node left = mergeSort(head);
        Node right = mergeSort(mid.next);
        mid.next = null;
        //merge
        Node merged = merge(left, right);
        return merged;
    }
    //zig zag linkedlist
    public static void zigzag(){
        if(head==null || head.next==null){
            return;
        }
        //find mid
        Node mid = findMid(head);
        //reverse 2nd half
        Node curr = mid.next;
        mid.next=null;
        Node prev = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left=head;
        Node right = prev;
        Node nextL,nextR;
        //alternative merge zig zag merge
        while(left!=null && right!=null){
            nextL = left.next;
            nextR = right.next;
            left.next = right;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }

       
      
    }
    //delete mid element
    public static Node deleteMid(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
    //remove dublicates element
    public static Node removeDuplicates(){
        if(head==null || head.next==null){
            return head;
        }
        Node curr = head;
        
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                //removing dublicates
                curr.next = curr.next.next;
            }else{
               //moving towords another elemnts if no dublicates exist
                curr = curr.next;
            }
        }
        return head;
    
    }
    //merge two sorted linkedlist
    public static Node mergeTwoSorted(Node head1,Node head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1!=null){
            temp.next = head1;
        }
        if(head2!=null){
            temp.next = head2;
        }
        return dummy.next;
    }
    //rotate a linkedlist
    class Solution {
        public Node rotateRight(Node head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
    
            Node temp = head;
            int count = 1;
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }
    
            k = k % count;
            if (k == 0) {
                return head;
            }
    
            temp.next = head;
            int stepsToNewTail = count - k;
            Node newTail = head;
            for (int i = 1; i < stepsToNewTail; i++) {
                newTail = newTail.next;
            }
    
            head = newTail.next;
            newTail.next = null;
    
            return head;
        }
    }
    
    //clone a linkedlist
    public static Node clone(Node head){
        if(head==null){
            return null;
        }
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node temp1 = head;
        while(temp1!=null){
            temp.next = new Node(temp1.data);
            temp = temp.next;
            temp1 = temp1.next;
        }
        return dummy.next;
    
    //reverse node in k group
    /*class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            int count = 0;
            while (curr != null && count < k) {
                curr = curr.next;
                count++;
            }
            if (count < k) {
                return head;
            }
            curr = head;
            ListNode prev = null, next = null;
            count = 0;
            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }
            return prev;
        }*/
    }
    

    public static void main(String[] args) {
        linkedlist ll = new linkedlist();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(1);
        //ll.addLast(5);
        //ll.addLast(5);

        // Print the list
        ll.print();

        // Add element in the middle
        //ll.addMiddle(35, 3);
       // ll.print();

        // Display size
        System.out.println("Size: " + ll.size);

        // Remove the first element
       // ll.removeFirst();
        //ll.print();

        // Remove the last element
       // ll.removeLast();
       // ll.print();

        // Search for an element
        if (ll.search(25)) {
            System.out.println("Element found");
        }
        else {
            System.out.println("Element not found");
        }

        // Search for an element using recursion
        System.out.println(ll.searchRec(head,25));

        // Reverse the list
       // ll.reverse();
      //ll.print();

        // Remove the nth node from the end
       // ll.removeNthFromEnd(3);
       // ll.print();

        // Check if the linked list is palindrome
        if (ll.isPalindrome()) {
            System.out.println("Linked list is palindrome");
        }
        else {
            System.out.println("Linked list is not palindrome");
        }

        // Check if the linked list has a loop
        System.out.println(Checkloop());

        // Remove the loop
        removeCycle();

        // Find the middle element
        Node mid = findMid(head);
        System.out.println("Middle element: " + mid.data);

        // Merge sort
        head = mergeSort(head);
        ll.print();

        // Zigzag
        zigzag();
        ll.print();


      

    }
}
