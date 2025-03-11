package LEVEL1;

public class array2 {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(arr[1]);
        System.out.println(arr.length);
        int sum=0;
        for(int number: arr ){// using for each loop
            sum+=number;
        }
        System.out.println("Sum is: "+sum);
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("Min is: "+min);
        System.out.println("Max is: "+max);
        int span=max-min;
        System.out.println("Span is: "+span);
    }
    
}
