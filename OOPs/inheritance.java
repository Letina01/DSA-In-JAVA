package OOPs;

class animal{
    String color;
    public void breathe(){
        System.out.println("animal can breathe");

    }

    public void eat(){
        System.out.println("animal can eat");

    }

}
class fish extends animal{
    int fins;
    public void swim(){
        System.out.println("fish can swim");

    }
}

public class inheritance {

    public static void main(String[] args) {
        fish f=new fish();
        f.breathe();
        f.eat();
        f.fins=2;
        System.out.println(f.fins);
        f.swim();
    }
    
}
