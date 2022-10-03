import java.util.*;

public class HuffmanCodes {
    class Node {
        int count;
        Node parent;
        Node left;
        Node right;

        public Node(int count) {
            this.count = count;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }

    private List<String> compress(String line, Map<Character, Integer> map) {
        for (Character c : line.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        Queue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            Node node = new Node(count);
            queue.offer(node);
        }
        /* build binary tree */
        while (queue.size() > 1) {
            Node node1 = queue.poll();
            Node node2 = queue.poll();
            Node parent = new Node(node1.count + node2.count);
            parent.left = node1;
            parent.right = node2;
            queue.add(parent);
        }
        Node tree = queue.poll();
        /* traversals to get bit-strings */
        List<String> result = new ArrayList<>();
        dfs(tree, result, new StringBuilder());
        return result;
    }

    /* depth-first search to help with tree traversals */
    private static void dfs(Node root, List<String> result, StringBuilder sb) {
        if (root == null) {
            result.add(sb.toString());
            return;
        }
        sb.append('0');
        dfs(root.left, result, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('1');
        dfs(root.right, result, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println("What string will you like to compress?");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        List<String> codes = new HuffmanCodes().compress(line, new HashMap<>());
        System.out.print("Huffman codes returned: ");
        System.out.println(codes);
    }
}
