import java.util.*;

public class GraphModels {

    /*
     * Bellman-Ford implementation of the dynamic programming algorithm (for
     * shortest path when
     * negative edges are included)
     */
    public static int bellmanFord(List<List<Integer>> edges, int dest) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> nodes = new HashSet<>();
        for (List<Integer> edge : edges) {
            int n = edge.get(0);
            int m = edge.get(1);
            nodes.add(n);
            nodes.add(m);
            List<Integer> neighbors = map.get(n);
            if (neighbors == null) {
                neighbors = new ArrayList<>();
            } else {
                neighbors.add(m);
            }
        }
        int n = nodes.size();

        int[][] dp = new int[n][nodes.size()];
        for (int i = 1; i < n; i++) {
            for (int v : nodes) {
                for (int w : map.get(v)) {
                    dp[i][v] = Math.min(dp[i - 1][v], dp[i - 1][w]);
                }
            }
        }
        return dp[n - 1][dest];
    }

    /*
     * implements Dijkstra's algorithm to find the shortest path from start - end
     */
    public static int dijkstra(List<List<Integer>> graph, int start, int end) {
        return 0;
    }

    /*
     * implements kruskal's algorithm to find the minimum spanning tree (with
     * Union-Find data structure)
     */
    public static Set<Edge> kruskals(Set<Edge> edges) {
        /* sort the edges */
        List<Edge> listOfEdges = new ArrayList<>(edges);
        Collections.sort(listOfEdges, new EdgeComparator());
        Set<String> nodes = new HashSet<>();
        for (Edge edge : listOfEdges) {
            String node1 = edge.to;
            String node2 = edge.from;
            nodes.add(node1);
            nodes.add(node2);
        }
        Set<Edge> resultMst = new HashSet<>();
        UnionFind unionFind = new UnionFind(nodes);
        /* loop through the set till no cycles */
        for (Edge edge : listOfEdges) {
            if (unionFind.connected(edge.from, edge.to)) {
                continue;
            }
            unionFind.union(edge.from, edge.to);
            resultMst.add(edge);
        }

        return resultMst;
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
        Set<Integer> visited = new HashSet<>();
        int src = graph.get(0).get(0);
        queue.offer(src);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited.contains(node)) {

                /* odd cycles */
                return true;
            }
            for (int child : graph.get(node)) {
                queue.offer(child);
            }
            visited.add(node);
        }
        return false;
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

    private static void isGraphBipartite(Scanner scanner) {
        System.out.println("Whats the friend grouping");
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

    private static Edge getEdge(String line) {
        String[] strArr = line.split(" ");
        if (strArr.length == 3) {
            Edge edge = new Edge(strArr[0], strArr[1], Integer.parseInt(strArr[2]));
            return edge;
        }
        return null;
    }

    private static void classSchedule() {
        Set<Edge> edges = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the 2 nodes, and the weight");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() == 0) {
                break;
            }
            Edge edge = getEdge(line);
            if (edge != null) {
                edges.add(edge);
            }
        }
        scanner.close();
        /* MST computation */
        Set<Edge> mst = kruskals(edges);
        System.out.println(mst);
    }

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Check graph is bipartite\n2. Class graph\n");
        int mode = scanner.nextInt();
        if (mode == 2) {
            classSchedule();
        } else if (mode == 1) {
            isGraphBipartite(scanner);
        } else {
            System.out.println("Quiting...");
            scanner.close();
        }

    }

}

class Edge {
    String from;
    String to;
    int weight;

    public Edge(String to, String from, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public String toString() {
        return from + "-" + weight + "-" + to;
    }
}

class Node {
    String val;
    Node parent;

    public Node(String val) {
        this.val = val;
        this.parent = this;
    }
}

class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge edge1, Edge edge2) {
        return edge1.weight - edge2.weight;
    }
}

class UnionFind {
    Map<String, Node> map;
    int size;

    public UnionFind(Set<String> nodes) {
        this.map = new HashMap<>();
        for (String name : nodes) {
            map.put(name, new Node(name));
        }
    }

    public Node find(Node node) {
        Node pointer = node;
        while (!(pointer == pointer.parent)) {
            pointer = pointer.parent;
        }

        /* pointer points to root at the end */
        return pointer;
    }

    public void union(String name1, String name2) {
        Node node1 = map.get(name1);
        Node node2 = map.get(name2);
        if (find(node1) == find(node2)) {
            return;
        }
        map.put(name2, node1);
        node2.parent = node1;
    }

    public boolean connected(String name1, String name2) {
        return find(map.get(name1)) == find(map.get(name2));
    }
}