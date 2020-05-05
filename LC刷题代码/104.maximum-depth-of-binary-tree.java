/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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

/* DFS
 * 二叉树的最大深度问题用到深度优先搜索 Depth First Search，递归的完美应用
 * 图解：https://github.com/MisterBooo/LeetCodeAnimation/blob/master/0104-Maximum-
 * Depth-Of-Binary-Tree/Article/0104-Maximum-Depth-Of-Binary-Tree.md
 */
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
// @lc code=end


//DFS 深度优先  LC官网讨论区
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if (node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;
    }
    // 7ms

}


//BFS 广度优先搜索 LC官网讨论区
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
    // 3ms

}

/*
 * https://github.com/grandyang/leetcode/issues/104
 * 我们也可以使用层序遍历二叉树，然后计数总层数，即为二叉树的最大深度，注意 while 循环中的 for 循环的写法有个 trick，一定要将
 * q.size() 放在初始化里，而不能放在判断停止的条件中，因为q的大小是随时变化的，所以放停止条件中会出错，参见代码如下：
 */
class Solution {

    public class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int res = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                ++res;
                for (int i = q.size(); i > 0; --i) {
                    TreeNode t = q.poll();
                    if (t.left != null)
                        q.offer(t.left);
                    if (t.right != null)
                        q.offer(t.right);
                }
            }
            return res;
        }
    }

}