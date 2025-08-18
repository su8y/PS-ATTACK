ackage leetcode.com;

/**
 * invert Tree
 * best solution 은 그냥 스와핑 해주는것이다 recursion한 방법으로
 */
public class LeetCode226 {
    private static TreeNode traverNode(TreeNode root, TreeNode result) {
        // 얕은 복사로 이루어져있기 때문에 그냥 바로 값을 넣는게 가능하다 .ㅓㅓㅏ
        if (root == null) return null;
        result = new TreeNode(root.val);
        result.left = traverNode(root.right, result.left);
        result.right = traverNode(root.left, result.right);

        return result;

    }

    public TreeNode invertTree(TreeNode root) {
        TreeNode result = null;
        if (root == null) return null;
        result = new TreeNode(root.val);

        result.left = traverNode(root.right, result.left);
        result.right = traverNode(root.left, result.right);

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
