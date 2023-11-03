import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    List<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

class Solution {
    int diameter;

    public int diameter(Node root) {
        diameter = 0;
        depth(root);
        return diameter;
    }

    private int depth(Node node) {
        if (node == null) {
            return 0;
        }

        int maxDepth1 = 0;
        int maxDepth2 = 0;

        for (Node child : node.children) {
            int d = depth(child);
            if (d > maxDepth1) {
                maxDepth2 = maxDepth1;
                maxDepth1 = d;
            } else if (d > maxDepth2) {
                maxDepth2 = d;
            }
        }

        diameter = Math.max(diameter, maxDepth1 + maxDepth2);

        return maxDepth1 + 1;
    }
}

public class NTreeDiameter {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1);
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        Solution solution = new Solution();
        System.out.println(solution.diameter(root)); // Output: 3
    }
}
