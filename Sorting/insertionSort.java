package Sorting;

public class insertionSort {

    public static void insertionSorting(int arr[]){

        for(int i=1;i<arr.length;i++){

            int curr=arr[i];

            int prev=i-1;

            while(prev>=0 && arr[prev]>arr[curr]){

                arr[prev+1]=arr[prev];

                prev--;
            }

            arr[prev+1]=arr[curr];
        }

    }

    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){

            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){

        int arr[]={4,9,2,3,10};
        insertionSorting(arr);
        printarr(arr);

    }
    
}
