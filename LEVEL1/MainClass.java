package LEVEL1;
import java.util.Scanner;

public class MainClass{
    @SuppressWarnings("resource")
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sp=n/2, st=1;
        for(int i=1;i<=n;i++){
            //System.out.println(sp+"*"+st);
            for(int j=1;j<=sp;j++){
                System.out.print("\t");
            }

            for(int j=1;j<=st;j++){
                System.out.print("*\t");
            }
            if(i<=n/2){
                sp--;
                st+=2;
            }else{  
                sp++;
                st-=2;

            }

            System.out.println();

        }
     

    }
    
}
