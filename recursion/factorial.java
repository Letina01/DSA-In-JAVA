package recursion;

public class factorial {
    public static void calFactorial(int n){

        if(n==0 || n==1){
            System.out.println(1);
        }else{
            int fact=1;
            for(int i=1;i<=n;i++){
                fact=fact*i;
            }
            System.out.println(fact);
        }
    }
    //sum of first n natural number

    public static int calSum(int n){

        if(n==1){
            return 1;
        }
        return n+calSum(n-1);
    }

    public static void main(String[] args) {

        calFactorial(5);
        System.out.println(calSum(5));

    }
    
}
