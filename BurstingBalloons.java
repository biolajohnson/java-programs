import java.util.*;

public class BurstingBalloons {

    private static int burstBalloons(List<Integer> balloons) {
        balloons.add(0, 1);
        balloons.add(1);
        return burst(1, balloons.size() - 2, balloons, new HashMap<>());
    }

    private static int burst(int left, int right, List<Integer> balloons, Map<String, Integer> map) {
        if (left > right) {
            return 0;
        }
        String key = "" + left + "" + right;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int coins = 0;
        map.put(key, coins);
        for (int j = left; j < right + 1; j++) {
            coins = balloons.get(left - 1) * balloons.get(j) * balloons.get(right + 1);
            coins += burst(j + 1, right, balloons, map) + burst(left, j - 1, balloons, map);
            coins = Math.max(map.get("" + left + "" + right), coins);
            map.put("" + left + "" + right, coins);
        }
        return coins;
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
