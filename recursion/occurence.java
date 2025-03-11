package recursion;

public class occurence {

    public static int Firstoccurence(int arr[],int x,int i){
        if(i==arr.length){
            return -1;
        }

        if(arr[i]==x){
            return i;
        }

        return Firstoccurence(arr,i+1,x);
    }
    public static int lastoccurence(int arr[],int x,int i){
        if(i==arr.length){
            return -1;
        }
        int isfound=lastoccurence(arr, x, i+1);

        if(isfound==-1 && arr[i]==x){
            return isfound;
        }
        if(arr[i]==x){
            return i;
        }

        return isfound;

        
    }
    public static int printPower(int x,int n){

        if(n==1){
            return 1;
        }

        return x*printPower(x,n-1);
       
        
    }

    public static void main(String[] args) {

        int arr[]={2,3,4,5,6,7,8,9};

        System.out.println(Firstoccurence(arr,8,0));

        System.out.println(lastoccurence(arr,8,0));

        printPower(2,5);

    }
    
}
