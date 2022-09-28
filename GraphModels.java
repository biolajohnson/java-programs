import java.util.*;

public class GraphModels {

    /*
     * implements Dijkstra's algorithm to find the shortest path from start - end
     */
    public static int shortestDistance(List<List<Integer>> graph, int start, int end) {
        return 0;
    }

    /* implements kruskal's algorithm to find the minimum spanning tree */
    public static Set<Integer> kruskals(List<List<Integer>> graph) {
        return new HashSet<>();
    }

    /* implements prim's algorithm to find the minimum spanning tree */
    public static Set<Integer> prims(List<List<Integer>> graph) {
        return new HashSet<>();
    }

    /* check if graph is bi-partite */
    public static boolean checkBipartite(List<List<Integer>> graph) {
        return twoColoring(graph) && hasOddCycles(graph);
    }

    private static boolean hasOddCycles(List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Set<Integer>> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> level = new HashSet<>();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (level.contains(node)) {
                    return false;
                }
                for (int child : graph.get(node)) {
                    queue.add(child);
                }
            }
            visited.add(level);
        }
        return true;
    }

    private static boolean twoColoring(List<List<Integer>> graph) {
        return true;
    }

    /* returns an ordering of nodes (DAG) */
    public static List<Integer> topologicalSort(List<List<Integer>> graph) {
        return new ArrayList<>();
    }

    /* Depth first search */
    public static Set<Integer> depthFirstSearch(List<List<Integer>> graph, int src) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(src);
        while (!stack.empty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                for (int child : graph.get(node)) {
                    stack.push(child);
                }
                visited.add(node);
            }
        }
        return visited;
    }

    /* Breadth first search */
    public static Set<Integer> breadFirstSearch(List<List<Integer>> graph, int src) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(src);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited.contains(node)) {
                for (int child : graph.get(node)) {
                    queue.add(child);
                }
                visited.add(node);
            }
        }
        return visited;
    }

    public static void main(String[] arg) {
        System.out.println("Whats the friend grouping");
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> adjList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            List<Integer> res = new ArrayList<>();
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break;
            }
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                res.add(Integer.parseInt(token));
            }
            adjList.add(res);
        }
        boolean isBipartite = checkBipartite(adjList);
        System.out.println("Is the graph bipartite ? " + isBipartite);
        Set<Integer> bfsResult = breadFirstSearch(adjList, 0);
        Set<Integer> dfsResult = depthFirstSearch(adjList, 0);
        System.out.println("The result of Breadth-First search: \n" + bfsResult);
        System.out.println("The result of Depth-First search: \n" + dfsResult);
        scanner.close();
    }

}
