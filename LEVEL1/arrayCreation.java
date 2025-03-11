package LEVEL1;

public class arrayCreation {

    public static void main(String[] args) {
       int marks[]=new int[50];
       Scanner sc = new Scanner(System.in);
       marks[0]= sc.nextInt();
       marks[1]= sc.nextInt();
       marks[2]= sc.nextInt();
       marks[3]= sc.nextInt();
       marks[1]=marks[1]+9;//uodate

       System.out.println("eng: "+marks[1]);
       System.out.println("phy: "+marks[0]);
;
    }
    
}
