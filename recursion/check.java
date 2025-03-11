package recursion;

public class check {
    public static boolean CheckSort(int arr[],int i){
        if(arr[i]>arr[i+1]){
            return false;
        }

        if(i==arr.length-2){
            return true;
        }

        return CheckSort(arr,i+1);

    }

    public static void main(String[] args) {

        int n[]={1,2,3,4,8,5};
        System.out.println( CheckSort(n,0));

    }
    
}
