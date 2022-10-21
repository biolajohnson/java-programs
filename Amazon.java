import java.util.*;

public class Amazon {

    private static int countDecreasingRatings(int[] ratings) {
        int start = 0;
        int end = 1;
        int groups = 0;
        while (end < ratings.length) {
            if (ratings[end - 1] - ratings[end] == 1) {
                groups += end - start;
            } else {
                start = end;
            }
            end += 1;
        }
        return groups + ratings.length;
    }

    private static int[] getRatings(String line) {
        String[] numbers = line.split(" ");
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            result[i] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("What are your ratings: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] ratings = getRatings(line);
        int result = countDecreasingRatings(ratings);
        System.out.println("The number of decreasing ratings: " + result);
        scanner.close();
    }
}