package Queue;
import java.util.Deque;
import java.util.LinkedList;
public class queueUsingDeque {
    static class deque{

        Deque<Integer> deque = new LinkedList<>();

        public void enqueue(int data){
            deque.addLast(data);
        }

        public int dequeue(){
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        deque q = new deque();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("peek : "+q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }
    
}
