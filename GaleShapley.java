import java.util.*;

public class GaleShapley {
    /* implements the Gale-Shapley stable matching algorithm */
    private static List<List<Integer>> getStableMatching(List<Integer> prefList1, List<Integer> prefList2) {
        return new ArrayList<>();
    }

    /* helper function to get preference list */
    private static List<Integer> getPrefList(String str) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> prefList1 = getPrefList(scanner.nextLine());
        List<Integer> prefList2 = getPrefList(scanner.nextLine());
        scanner.close();
        List<List<Integer>> matching = getStableMatching(prefList1, prefList2);
        System.out.println("The Gale-Shapley algorithm returned:\n" + matching);
    }
}
