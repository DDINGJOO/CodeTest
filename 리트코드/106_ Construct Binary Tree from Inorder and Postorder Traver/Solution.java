import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[n - 1]);
        ArrayDeque<TreeNode> spine = new java.util.ArrayDeque<>();
        spine.push(root);

        int inorderIndex = n - 1;
        for (int postorderIndex = n - 2; postorderIndex >= 0; postorderIndex--) {
            int nextValue = postorder[postorderIndex];
            TreeNode parent = spine.peek();

            if (parent.val != inorder[inorderIndex]) {
                parent.right = new TreeNode(nextValue);
                spine.push(parent.right);
                continue;
            }

            while (!spine.isEmpty() && spine.peek().val == inorder[inorderIndex]) {
                parent = spine.pop();
                inorderIndex--;
            }

            parent.left = new TreeNode(nextValue);
            spine.push(parent.left);
        }

        return root;
    }
}
