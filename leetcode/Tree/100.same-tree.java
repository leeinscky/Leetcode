import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
class Solution { // 方法1:recursion 递归 （简单暴力）

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null 都是空的肯定相同
        if (p == null && q == null)
            return true;
        // one of p and q is null 有一个是空的肯定不相同
        if (q == null || p == null)
            return false;
        //将p节点值与q比较，如果两个数值大小不一样，那么肯定不一样
        if (p.val != q.val) 
            return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}


/*
class Solution {  // 方法2: Iteration 迭代

    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null)
            return true;
        // one of p and q is null
        if (q == null || p == null)
            return false;
        if (p.val != q.val)
            return false;
        return true;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (!check(p, q))
            return false;

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q))
                return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left))
                    return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right))
                    return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }
}
*/


// @lc code=end

/*
 * 分析 方法1: The simplest strategy here is to use recursion. Check if p and q
 * nodes are not None, and their values are equal. If all checks are OK, do the
 * same for the child nodes recursively.
 * 
 * Time complexity : O(N), where N is a number of nodes in the tree, since one
 * visits each node exactly once.
 * 
 * Space complexity : O(log(N)) in the best case of completely balanced tree and
 * O(N) in the worst case of completely unbalanced tree, to keep a recursion
 * stack.
 * 
 * 平衡二叉查找树：简称平衡二叉树： 1. 可以是空树。 2.假如不是空树，任何一个结点的左子树与右子树都是平衡二叉树，并且高度之差的绝对值不超过 1。
 * 平衡之意，如天平，即两边的分量大约相同。可以看出当节点数目一定，保持树的左右两端保持平衡，树的查找效率最高。
 * 
 * 二叉搜索树的查找效率取决于树的高度，因此保持树的高度最小，即可保证树的查找效率。非平衡二叉树：在此二叉搜索树中查找元素 6 需要查找 6 次。
 * 平衡二叉树：同样的序列 A，将其改为平衡二叉树的方式存储，查找元素 6 时只需比较 3 次，查找效率提升一倍。
 * 
 * 
 * 
 * 分析 方法2： Start from the root and then at each iteration pop the current node
 * out of the deque. Then do the same checks as in the approach 1 :
 * 
 * p and p are not None, p.val is equal to q.val,
 * 
 * and if checks are OK, push the child nodes. Time complexity :
 * \mathcal{O}(N)O(N) since each node is visited exactly once.
 * 
 * Space complexity : \mathcal{O}(\log(N))O(log(N)) in the best case of
 * completely balanced tree and \mathcal{O}(N)O(N) in the worst case of
 * completely unbalanced tree, to keep a deque.
 */