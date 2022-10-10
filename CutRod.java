import java.util.*;

public class CutRod {
    private static List<Integer> getPrices(String line) {
        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(line);
        while (sc.hasNext()) {
            int price = sc.nextInt();
            result.add(price);
        }
        sc.close();
        return result;
    }

    private static int getMaxPrice(List<Integer> prices, int length) {
        if (length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < length; i++) {
            int newMax = getMaxPrice(prices, length - i);
            max = Math.max(max, prices.get(i) + newMax);
        }
        return max;
    }

    private static int getMaxPriceOptimized(List<Integer> prices, int length) {
        int[] memo = new int[length + 1];
        memo[0] = 0;
        for (int i = 1; i <= length; i++) {
            int running = 0;
            for (int j = 1; j < i; j++) {
                running = Math.max(running, prices.get(j) + memo[i - j]);
            }
            memo[i] = running;
        }
        return memo[length];
    }

    public static void main(String[] args) {
        System.out.println("What are the prices: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Integer> prices = getPrices(line);
        System.out.println("What is the length: ");
        int length = scanner.nextInt();
        int max = getMaxPrice(prices, length);
        int optMax = getMaxPriceOptimized(prices, length);
        System.out.println("The max price for length " + length + " is: $" + max);
        System.out.println("The max price for length (optimized) " + length + " is: $" + optMax);
        scanner.close();
    }
}