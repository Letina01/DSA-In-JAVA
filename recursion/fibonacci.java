package recursion;

import java.util.Scanner;

public class fibonacci {

    public static int calFibonacci(int n) {

        if(n==0 || n==1){
            return n;
        }

        return calFibonacci(n-1) + calFibonacci(n-2);
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci number is: "+calFibonacci(n));

    }
    
}
