package LinkedList;
import java.util.LinkedList;

public class collection {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addFirst(3);
        //remove
        list.removeLast();
        list.removeFirst();
        
        System.out.println(list);
    }
    
}
