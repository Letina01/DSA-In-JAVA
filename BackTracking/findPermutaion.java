package BackTracking;

public class findPermutaion {
    //permutaion of n is n!

    public static void FindPermutation(String p, String up) {

        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        for (int i = 0; i < up.length(); i++) {
            char ch = up.charAt(i);
            String ros = up.substring(0, i) + up.substring(i + 1);
            FindPermutation(p + ch, ros);
        }
    }

    public static void main(String[] args) {

        String str = "abc";

        FindPermutation("", str);

    }
    
}
