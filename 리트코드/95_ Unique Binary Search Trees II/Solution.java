import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
        return new UniqueBstBuilder(n).buildAll();
    }

    private static final class UniqueBstBuilder {
        private final int size;
        private final List<TreeNode>[][] cache;


        private UniqueBstBuilder(int size) {
            this.size = size;
            this.cache = new List[size + 2][size + 2];
        }

        private List<TreeNode> buildAll() {
            return build(1, size);
        }

        private List<TreeNode> build(int start, int end) {
            if (start > end) {
                return Collections.singletonList(null);
            }

            if (cache[start][end] != null) {
                return cache[start][end];
            }

            List<TreeNode> trees = new ArrayList<>();

            for (int rootValue = start; rootValue <= end; rootValue++) {
                List<TreeNode> leftSubtrees = build(start, rootValue - 1);
                List<TreeNode> rightSubtrees = build(rootValue + 1, end);

                for (TreeNode leftSubtree : leftSubtrees) {
                    for (TreeNode rightSubtree : rightSubtrees) {
                        trees.add(new TreeNode(rootValue, leftSubtree, rightSubtree));
                    }
                }
            }

            cache[start][end] = trees;
            return trees;
        }
    }
}
