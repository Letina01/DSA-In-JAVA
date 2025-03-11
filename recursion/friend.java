package recursion;

public class friend {

    public static int countFriendsPairing(int n) {

        if(n==0 || n==1 || n==2){
            return n;
        }

        return countFriendsPairing(n-1) + (n-1)*countFriendsPairing(n-2);
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println("no of pairs"+countFriendsPairing(n));

    }
    
}
