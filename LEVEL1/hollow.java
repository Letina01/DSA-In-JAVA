package LEVEL1;

public class hollow {
    public static void HollowRectangle(int r,int c){
       //outer loop
        for(int i=1;i<r;i++){

            //innerloop
            for(int j=1;j<=c;j++){

                if(i==1 || i==r || j==1 || j==c){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }

            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        HollowRectangle(5,4);

    }
    
}
