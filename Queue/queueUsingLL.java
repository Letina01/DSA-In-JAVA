package Queue;

public class queueUsingLL {

    class Node{

        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class Queue{
        
    static Node head=null;
    static Node tail=null;

    public static boolean isEmpty(){
        return head==null && tail==null;
    }

    public static void enqueue(int data){

        queueUsingLL queue = new queueUsingLL();
        Node newNode = queue.new Node(data);

        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }

    public static int peek(){

        if(head==null){
            return -1;
        }
        return head.data;
    }

    public static int dequeue(){

        if(head==null){
            return -1;
        }

        int val = head.data;

        if(head==tail){
            head=tail=null;
        }else{
            head=head.next;
        }
            return val;
        }
        
        
    }
    
    public static void main(String[] args) {

        Queue q = new Queue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        while(!q.isEmpty()){

            System.out.println(q.peek());

            q.dequeue();

        }


    }
    
}
