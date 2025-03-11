package LEVEL1;

public class pair {

    public static void pairArray(int number[]){
        int totalpair=0;//fotmula (n*(n-1))/2

        for(int i=0;i<number.length;i++){
            int curr=number[i];

            for(int j=i+1;j<number.length;j++){

                System.out.print("("+curr+" ,"+number[j]+")");
                totalpair++;

            }
            System.out.println();

        }

        System.out.println("Total pair is: "+totalpair);

    }

    public static void main(String[] args) {

        int number[]={2,4,6,8,10,12,14,16};

        pairArray(number);
        
    }
    
}
//tc=O(n^2)