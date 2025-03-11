package Sorting;

public class bubbleSort {
    public static void bubbleSorting(int arr[]){
        for(int turn=0;turn<arr.length-1;turn++){

            for(int i=0;i<arr.length-1-turn;i++){

                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }

    }
    public static void printarr(int arr[]) {

        for(int i=0;i<arr.length;i++){

            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[]={3,4,16,5};
        bubbleSorting(arr);
        printarr(arr);

        

    }
    
}
//O(n^2)