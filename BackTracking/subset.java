package BackTracking;

public class subset {
    public static void Printsubset(String str, String ans, int i){
        //base case

        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }
            System.out.println(ans);
            return;
        }
        //yes choice
        Printsubset(str, ans + str.charAt(i), i + 1);
        //no choice
        Printsubset(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        Printsubset(str, "", 0);
    }
}