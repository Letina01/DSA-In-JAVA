package LEVEL1;

public class subarray {
    public static void printsubArray(int num[]){
        int ts=0;
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        int prefix[]=new int[num.length];
        prefix[0]=num[0];

        for(int i=1;i<prefix.length;i++){

            prefix[i]=prefix[i-1]+num[i];

        }

        for(int i=0;i<num.length;i++){
            int start=i;

            for(int j=i;j<num.length;j++){
                int end=j;
            //currsum=start==0 ? prefix[end] : prefix[end] -prefix[start-1];

                for(int k=start;k<=end;k++){

                    System.out.print(num[k]+" ");

                    currsum+=num[k];
                }
                System.out.println("the currsum is : "+currsum);
                if(maxsum<currsum){
                    maxsum=currsum;

                }

                ts++;

                System.out.println();
            }
            System.out.println();
        }

        System.out.println("Max subarray is: "+maxsum);

        System.out.println("Total subarray is: "+ts);

    }

    public static void main(String[] args){

        int num[]={2,4,6,8,10,12,14,16};

        printsubArray(num);

    }
    
}
