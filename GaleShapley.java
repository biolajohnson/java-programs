import java.util.*;


public class GaleShapley {
    /* implements the Gale-Shapley stable matching algorithm */
    private static Set<Map.Entry<String, String>> getStableMatching(Map<String, Stack<String>> map1,
            Map<String, Stack<String>> map2) {

        /* preprocess step (setting up the ranking for the women) */
        Map<String, Map<String, Integer>> womenRanking = new HashMap<>();
        for (Map.Entry<String, Stack<String>> entry : map2.entrySet()) {
            Stack<String> stack = new Stack<>();
            int i = 0;
            Map<String, Integer> ranking = new HashMap<>();
            while (!stack.empty()) {
                stack.push(entry.getValue().peek());
                ranking.put(entry.getValue().pop(), i++);
            }
            while (!stack.empty()) {
                entry.getValue().push(stack.pop());
            }
            womenRanking.put(entry.getKey(), ranking);
        }

        Map<String, String> engagementsMap = new HashMap<>();
        /* crux of the algorithm */
        Queue<String> queue = new LinkedList<>();
        for (Map.Entry<String, Stack<String>> entry : map1.entrySet()) {
            String man = entry.getKey();
            queue.add(man);
        }
        while (!queue.isEmpty()) {
            /* take a man from queue */
            String man = queue.poll();
            Stack<String> prefList = map1.get(man);
            String woman = prefList.pop();
            if (engagementsMap.get(woman) == null) {
                engagementsMap.put(woman, man);
            } else if (womenRanking.get(woman).get(engagementsMap.get(woman)) > womenRanking.get(woman).get(man)) {
                String prevMan = engagementsMap.get(woman);
                engagementsMap.replace(woman, prevMan, man);
                queue.add(prevMan);
            } else {
                queue.add(man);
            }
        }
        return engagementsMap.entrySet();
    }

    /* helper function to get preference list */
    private static void getPrefList(String str, Map<String, Stack<String>> map) {
        String[] names = str.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = names.length - 1; i > 0; i--) {
            stack.push(names[i]);
        }
        map.put(names[0], stack);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Stack<String>> map1 = new HashMap<>();
        Map<String, Stack<String>> map2 = new HashMap<>();
        System.out.println("Enter the Man and prefered women");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break;
            }
            getPrefList(line, map1);
        }

        System.out.println("Enter the Woman and prefered men");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break;
            }
            getPrefList(line, map2);
        }

        scanner.close();
        Set<Map.Entry<String, String>> matching = getStableMatching(map1, map2);
        System.out.println("The Gale-Shapley algorithm returned:\n" + matching);
    }
}
