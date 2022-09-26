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

    public static boolean insideOutsideCheck(String str) {
        int i, j;
        int n = str.length();
        /* odd length string */
        if (str.length() % 2 == 1) {
            i = n / 2;
            j = i;
        } else {
            /* even length string */
            j = n / 2;
            i = j - 1;
        }
        while (i >= 0 && j < n) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the the input string? ");
        String str = scanner.next();
        /* using checkPalindrome */
        boolean isPalindrome = checkPalindrome(str);
        System.out.println(str + " is palindrome? " + isPalindrome + " (using regular method)");

        /* using insideOutCheck */
        boolean insideOutResult = insideOutsideCheck(str);
        System.out.println(str + " is palindrome? " + insideOutResult + " (using inside out method)");
        scanner.close();
    }
}
