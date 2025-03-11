package recursion;

public class binary {
    public static void binaryString(int n,int lastPlace,StringBuilder str){

        if(n==0){
            System.out.println(str);
        }

        binaryString(n-1,0,str.append("0"));
        if(lastPlace==0){
            binaryString(n-1,1,str.append("1"));
        }

    }

       
    public static void main(String[] args) {

        binaryString(3,0,new StringBuilder());

      
    }
    
}
//print all binary strings of size N without consecutive ones