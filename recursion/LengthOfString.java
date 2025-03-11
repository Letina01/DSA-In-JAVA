package recursion;

public class LengthOfString {

    public static int lengthOfString(String str) {

        if (str.length() == 0) {
            return 0;
        }

        return 1 + lengthOfString(str.substring(1));
    }

    public static void main(String[] args) {

        String str = "hello";

        System.out.println(lengthOfString(str));

    }
    
}
