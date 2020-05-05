/*tree | depth-first-search | breadth-first-search
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
 * Approach 1: Recursive 弄懂了 Two trees are a mirror reflection of each other if:
 * 1. Their two roots have the same value. 2. The right subtree of each tree is
 * a mirror reflection of the left subtree of the other tree. Complexity
 * Analysis
 * 
 * Time complexity : O(n). Because we traverse the entire input tree once, the
 * total run time is O(n), where n is the total number of nodes in the tree.
 * 
 * Space complexity : The number of recursive calls is bound by the height of
 * the tree. In the worst case, the tree is linear and the height is in O(n).
 * Therefore, space complexity due to recursive calls on the stack is O(n) in
 * the worst case. 
 * 时间复杂度：O(n)O(n)，因为我们遍历整个输入树一次，所以总的运行时间为 O(n)O(n)，其中 nn
 * 是树中结点的总数。 空间复杂度：递归调用的次数受树的高度限制。在最糟糕情况下，树是线性的，其高度为
 * O(n)O(n)。因此，在最糟糕的情况下，由栈上的递归调用造成的空间复杂度为 O(n)O(n)。
 * 
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-
 * shu-by-leetcode/ 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        // 把问题变成判断两棵树是否是对称的
        return isSym(root.left, root.right);
    }

    // 判断的是根节点为r1和r2的两棵树是否是对称的
    public boolean isSym(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        if (r1 == null || r2 == null)
            return false;
        // 这两棵树是对称需要满足的条件：
        // 1.俩根节点相等。 2.树1的左子树和树2的右子树，树2的左子树和树1的右子树都得是对称的
        return r1.val == r2.val && isSym(r1.left, r2.right) && isSym(r1.right, r2.left);
    }
}


/*
 * Approach 2: Iterative 没弄懂
 * 
 * Instead of recursion, we can also use iteration with the aid of a queue. Each
 * two consecutive nodes in the queue should be equal, and their subtrees a
 * mirror of each other. Initially, the queue contains root and root. Then the
 * algorithm works similarly to BFS, with some key differences. Each time, two
 * nodes are extracted and their values compared. Then, the right and left
 * children of the two nodes are inserted in the queue in opposite order. The
 * algorithm is done when either the queue is empty, or we detect that the tree
 * is not symmetric (i.e. we pull out two consecutive nodes from the queue that
 * are unequal). 
 * 除了递归的方法外，我们也可以利用队列进行迭代。队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。最初，队列中包含的是
 * root 以及 root。该算法的工作原理类似于BFS，但存在一些关键差异。每次提取两个结点并比较它们的值。
 * 然后，将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
 * 
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-
 * shu-by-leetcode/ 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


/*
class Solution {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll(); //获取第一个元素作为t1 poll是队列数据结构实现类的方法，从队首获取一个元素，同时获取的这个元素将从原队列删除
            TreeNode t2 = q.poll(); //获取第二个元素作为t2
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
*/

// @lc code=end

