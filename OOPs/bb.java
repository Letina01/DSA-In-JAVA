package OOPs;
class bank{
    String username;
    int password;
    public void setname(){
        username="Anjali";

    }
    public void setpassword(){
        password=1234;
    }
}
public class bb {

    public static void main(String[] args) {

        bank b=new bank();
        b.setname();
        b.setpassword();

        System.out.println(b.username);
        System.out.println(b.password);

       

    }
    
}
