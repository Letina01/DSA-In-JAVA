package recursion;

public class tiling {

    public static int tilingProblem(int n) {//2*n floor size

        if(n==0 || n==1){
            return 1;
        }

        return tilingProblem(n-1) + tilingProblem(n-2);
    }

    public static void main(String[] args) {

        System.out.println(tilingProblem(4));

    }
    
}
