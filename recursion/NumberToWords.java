package recursion;

public class NumberToWords {

    // Array to map digits to their English words
    static String[] digitsInWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    // Recursive function to convert the number to words
    public static void numberToWords(int number) {
        // Base case: If the number becomes 0, return (end recursion)
        if (number == 0) {
            return;
        }

        // Recursive call: First process the number without the last digit
        numberToWords(number / 10);

        // Extract the last digit and print its corresponding word
        int lastDigit = number % 10;
        System.out.print(digitsInWords[lastDigit] + " ");
    }

    public static void main(String[] args) {
        // Example number
        int number = 2019;

        // Edge case handling if the number is 0
        if (number == 0) {
            System.out.println("zero");
        } else {
            // Call the recursive function
            numberToWords(number);
        }
    }
}
