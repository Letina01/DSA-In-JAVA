package Sorting;

public class selectionSort {

    public static void selectionSorting(int arr[]){

        for(int i=0;i<arr.length-1;i++){

            int min=i;

            for(int j=i+1;j<arr.length;j++){

                if(arr[j]<arr[min]){

                    min=j;
                }
            }
            //swap

            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;


        }

    }

    public static void printarr(int arr[]) {

        for(int i=0;i<arr.length;i++){

            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){

        int arr[]={4,9,2,3,10};
        selectionSorting(arr);
        printarr(arr);

    }
    
}
