import java.util.*;

public class TrappedWater {

    public static List<Integer> getTopography(String line) {
        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(line);
        while (sc.hasNext()) {
            int value = sc.nextInt();
            result.add(value);
        }
        sc.close();
        return result;
    }

    public static int getTrappedWater(List<Integer> topography) {
        int i = 0;
        int j = topography.size() - 1;
        int maxVolume = 0;
        int leftMax = 0, rightMax = 0;
        while (i < j) {
            if (topography.get(i) < topography.get(j)) {
                if (leftMax > topography.get(i)) {
                    maxVolume += (leftMax - topography.get(i));
                } else {
                    leftMax = topography.get(i);
                }
                i++;
            } else {
                if (rightMax > topography.get(j)) {
                    maxVolume += (rightMax - topography.get(j));
                } else {
                    rightMax = topography.get(j);
                }
                j--;
            }

        }
        return maxVolume;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("State the topography: ");
        String line = scanner.nextLine();
        List<Integer> topograpy = getTopography(line);
        int maxVolume = getTrappedWater(topograpy);
        System.out.println("Max volume of trapped water in this scenerio is: " + maxVolume + " units");
        scanner.close();
    }
}
