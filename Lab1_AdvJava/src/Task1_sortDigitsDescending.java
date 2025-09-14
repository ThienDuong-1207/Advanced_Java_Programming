import java.util.Arrays;
import java.util.Scanner;

public class Task1_sortDigitsDescending {
    public static int sortDigitDescending(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        // Sort array in ascending order
        Arrays.sort(digits);

        // Build string in descending order
        StringBuilder sb = new StringBuilder(new String(digits));
        sb.reverse();

        // Convert back to int
        return Integer.parseInt(sb.toString());
    }

    // Main to test function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Allow multiple numbers separated by spaces
        System.out.print("Enter numbers (separated by spaces): ");
        String[] inputs = scanner.nextLine().split(" ");

        for (String s : inputs) {
            int num = Integer.parseInt(s);
            System.out.println("Input: " + num + " -> Output: " + sortDigitDescending(num));
        }

        scanner.close();
    }
}
