import java.util.*;

public class SeatsArrangments {

    public static int findSeatingArrangement(int seats) {
        int[] opt = new int[seats + 1];
        opt[1] = 2;
        opt[2] = 3;
        for (int i = 3; i <= seats; i++) {
            opt[i] = opt[i - 1] + opt[i - 2];
        }
        return opt[seats];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many seats: ");
        int seats = scanner.nextInt();
        int arrangements = findSeatingArrangement(seats);
        System.out.println("There are " + arrangements + " arrangments possible");
        scanner.close();
    }
}
