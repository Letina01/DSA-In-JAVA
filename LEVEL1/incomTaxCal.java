package LEVEL1;
import java.util.Scanner;

public class incomTaxCal {
    private static final String Syestem = null;

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        int tax;
  
        if(salary<500000){
            tax=0;
        }else if(salary>=500000 && salary<100000){
             tax=(int) (salary*0.2);


        }else{
            tax=(int) (salary*0.3);
        }
        
    }
    
}
