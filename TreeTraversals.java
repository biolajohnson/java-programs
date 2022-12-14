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

    public static void spiralLevelOrderAlt(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        LinkedList<String> list = new LinkedList<>();
        boolean oddSwitch = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (!oddSwitch) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                for (String str : list) {
                    System.out.print(str + " ");
                }
                System.out.println();
                list = new LinkedList<>();
                if (queue.size() > 0) {
                    oddSwitch = !oddSwitch;
                    queue.add(null);
                }
            }

        }

    }

    public static void pathsInTree(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.right == null && root.left == null) {
            paths.add(path);
        } else {
            path += "->";
            pathsInTree(root.left, path, paths);
            pathsInTree(root.right, path, paths);
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
        System.out.println("Spiral level order traversal (Alt): ");
        spiralLevelOrderAlt(root);
        System.out.println("Paths on tree: ");
        List<String> result = new LinkedList<>();
        pathsInTree(root, "", result);
        for (String path : result) {
            System.out.println(path);
        }
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