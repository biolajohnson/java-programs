import java.util.*;

public class Palindromes {
    public static boolean checkPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the the input string? ");
        String str = scanner.next();
        boolean isPalindrome = checkPalindrome(str);
        System.out.println(str + " is palindrome? " + isPalindrome);
        scanner.close();
    }
}
