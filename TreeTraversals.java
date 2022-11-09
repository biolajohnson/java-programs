import java.util.*;

public class TreeTraversals {
    public static TreeNode buildCompleteTree(String[] list) {
        return insertTreeInOrder(list, 0);
    }

    private static TreeNode insertTreeInOrder(String[] list, int i) {
        TreeNode root = null;
        if (i < list.length) {
            root = new TreeNode(list[i]);
            root.left = insertTreeInOrder(list, 2 * i + 1);
            root.right = insertTreeInOrder(list, 2 * i + 2);
        }
        return root;
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                System.out.print(node.val + " ");
            }
            System.out.println();
        }
    }

    public static void spiralLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        boolean oddSwitch = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (!oddSwitch) {
                    System.out.print(node.val + " ");
                } else {
                    stack.push(node);
                }
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.print(node.val + " ");
            }
            System.out.println();
            oddSwitch = !oddSwitch;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What are the elements: ");
        String line = scanner.nextLine();
        String[] elements = line.split(" ");
        TreeNode root = buildCompleteTree(elements);
        System.out.println("Level order traversal: ");
        levelOrder(root);
        System.out.println("Spiral level order traversal: ");
        spiralLevelOrder(root);
        scanner.close();
    }

}

class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;

    public TreeNode(String val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}