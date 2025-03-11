package LinkedList;

public class doubbly {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;

        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    //addFirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        head.prev=newNode;
        newNode.next=head;
        head=newNode;
    }
    //addLast
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    //remove frist
    public int removeFirst(){
        if(head==null){
            System.out.println("List is empty");
            return -1;
        }
        size--;
        int val = head.data;
        if(head==tail){
            head=tail=null;
            return val;
        }
        head=head.next;
        head.prev=null;
        return val;
    }
    //remove last
    public int removeLast(){
        if(head==null){
            System.out.println("List is empty");
            return -1;
        }
        size--;
        int val = tail.data;
        if(head==tail){
            head=tail=null;
            return val;
        }
        tail=tail.prev;
        tail.next=null;
        return val;
    }
    //print
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    //reverse
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        doubbly dll = new doubbly();
        dll.addFirst(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.addLast(40);
        dll.addLast(50);
        dll.print();

        dll.removeFirst();
        dll.removeLast();
        dll.print();

        dll.reverse();
        dll.print();
        
    }
    
}
