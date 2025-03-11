package TwoDArray;

public class digonal {
    //n==m tc O(n^2)
    public static void digonalsum(int matrix[][]){
        int sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //primary digonal
                if(i==j){
                    sum+=matrix[i][j];
                }
                //secondary digonal
                else if(i+j==matrix.length-1){
                    sum+=matrix[i][j];
                }
            }
        }
        //tc )(n^2)
        //for_int i=0;i<matrix.length;i++){
        //sum=sum+mtrix[i][j];
        //if(i!=matrix.length-1-i)
        //sum =sum+,atrix[i][matrix.length-i-1];}
        //
        System.out.println(sum);
        
    }
    public static void main(String[] args) {
        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        digonalsum(matrix);

    }
    
}
