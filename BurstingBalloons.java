import java.util.*;

public class BurstingBalloons {

    private static int burstBalloons(List<Integer> balloons) {
        int max = 0;
        for (int i = 0; i < balloons.size(); i++) {
            int soFar = burst(i, balloons, 1);
            max = Math.max(max, soFar);
        }
        return max;
    }

    private static int burst(int i, List<Integer> balloons, int soFar) {
        if (balloons.size() == 0) {
            return soFar;
        }
        if (i > 0 && i < balloons.size() - 1) {
            soFar += (balloons.get(i - 1) * balloons.get(i) * balloons.get(i + 1));
        } else if (i > 0) {
            soFar += (balloons.get(i - 1) * balloons.get(i));
        } else {
            soFar += balloons.get(i);
        }
        balloons.remove(i);
        for (int j = 0; j < balloons.size(); j++) {
            int maxSoFar = burst(i, balloons, soFar);
            soFar = Math.max(soFar, maxSoFar);
        }
        return soFar;
    }

    private static List<Integer> getList(String line) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(line);
        while (sc.hasNextInt()) {
            int balloon = sc.nextInt();
            list.add(balloon);
        }
        sc.close();
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Integer> balloons = getList(line);
        int coins = burstBalloons(balloons);
        System.out.println("Max Coins: " + coins);
        scanner.close();
    }
}
