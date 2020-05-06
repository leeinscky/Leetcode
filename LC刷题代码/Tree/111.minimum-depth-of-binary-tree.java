/*tree | depth-first-search | breadth-first-search
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 */

// @lc code=start
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


/*
//美国站 讨论区置顶解法
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;

    }
}
*/

// 美国站 讨论区 （讨论区#1的换一种写法）
public class Solution {

    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        // 如果整个树的根节点没有左子树，最短深度并不是1。因为根据定义：The minimum depth is the number of nodes along
        // the shortest path from the root node down to the nearest leaf node. 所以至少要有一个叶子结点。所以返回右子树的最小深度 + 1（1:根节点）
        if (root.left == null)
            return minDepth(root.right) + 1;

        if (root.right == null)
            return minDepth(root.left) + 1;
        
        return Math.min( minDepth(root.left), minDepth(root.right) ) + 1;

    }

}

/*
//中国站官方题解 方法一：递归 （最直接的思路）
class Solution {

    public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    if ((root.left == null) && (root.right == null)) {
        return 1;
    }

    int min_depth = Integer.MAX_VALUE;
    if (root.left != null) {
        min_depth = Math.min(minDepth(root.left), min_depth);
    }
    if (root.right != null) {
        min_depth = Math.min(minDepth(root.right), min_depth);
    }

    return min_depth + 1;
    }

}
*/



// @lc code=end

