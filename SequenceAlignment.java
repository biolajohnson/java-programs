import java.util.*;

public class SequenceAlignment {
    /* constant delta value of 0.2 */
    private static double align(String strX, String strY) {
        double[][] result = new double[strX.length() + 1][strY.length() + 1];
        double delta = 0.2;
        int[] alphabets = new int[26];
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = i + 1;
        }

        for (int i = 0; i < result.length; i++) {
            result[i][0] = delta;
        }
        for (int j = 0; j < result.length; j++) {
            result[j][0] = delta;
        }
        for (int i = 1; i <= strX.length(); i++) {
            for (int j = 1; j <= strY.length(); j++) {
                float alpha = Math.abs(alphabets[strX.charAt(i - 1) - 'A'] - alphabets[strY.charAt(j - 1) - 'A']);
                result[i][j] = Math.min(Math.min(result[i - 1][j - 1] + alpha, result[i - 1][j] + delta),
                        result[i][j - 1] + delta);
            }
        }
        return result[strX.length()][strY.length()];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is string X: ");
        String strX = scanner.next();
        System.out.println("What is String Y: ");
        String strY = scanner.next();

        double similarity = align(strX, strY);
        System.out.println("Similarity: " + similarity);
        scanner.close();
    }
}
