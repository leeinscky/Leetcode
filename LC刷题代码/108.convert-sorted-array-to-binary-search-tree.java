import javax.swing.tree.TreeNode;

/* tree | depth-first-search
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
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


//题解链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/

// 方法一：中序遍历：始终选择中间位置左边元素作为根节点
class Solution {
    int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right)
            return null;

        // always choose left middle node as a root 考虑到数组可能有偶数个元素，始终选择中间位置左边元素作为根节点。右边元素也可以实现，都正确。
        int p = (left + right) / 2;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]); //创建根节点
        root.left = helper(left, p - 1);  // 递归创建左子树
        root.right = helper(p + 1, right);// 递归创建右子树
        
        return root;
    }

  public TreeNode sortedArrayToBST(int[] nums) {
    this.nums = nums;
    return helper(0, nums.length - 1);
  }

}

/*
 * 复杂度分析
 * 
 * 时间复杂度 O(N)，每个元素只访问一次。
 * 空间复杂度：O(N)，二叉搜索树空间 O(N)，递归栈深度 O(logN)。
 * 
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-
 * tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


//方法二：中序遍历：始终选择中间位置右边元素作为根节点
class Solution {
    int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right)
            return null;

        // always choose right middle node as a root
        int p = (left + right) / 2;
        if ((left + right) % 2 == 1)
            ++p;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

  public TreeNode sortedArrayToBST(int[] nums) {
    this.nums = nums;
    return helper(0, nums.length - 1);
  }
}


/*
 * 复杂度分析
 * 
 * 时间复杂度：\mathcal{O}(N)O(N)，每个元素只访问一次。
 * 
 * 空间复杂度：\mathcal{O}(N)O(N)，二叉搜索树空间 \mathcal{O}(N)O(N)，递归栈深度 \mathcal{O}(\log
 * N)O(logN)。
 * 
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-
 * tree/solution/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-15/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */




// @lc code=end

