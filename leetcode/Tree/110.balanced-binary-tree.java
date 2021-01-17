/* tree | depth-first-search
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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

//中文题解链接: https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode/

//方法一：自顶向下的递归
class Solution {

    // Recursively obtain the height of a tree. An empty tree has -1 height
    private int height(TreeNode node) { //通过迭代的思路求某一个树的高度，树的高度 = Math.max(左子树高度，右子树高度) 当迭代到最后，只剩叶子结点：Math.max(1,0) 或者 Math.max(1,1),...
    if (node == null) {
        return -1; // An empty tree has height -1 空树的高度=-1
    }

    return 1 + Math.max(height(node.left), height(node.right)); 
    }

    public boolean isBalanced(TreeNode root) {
    // An empty tree satisfies the definition of a balanced tree
    if (root == null) {
        return true;
    }

    // Check if subtrees have height within 1. If they do, check if the subtrees are balanced
    // 高度平衡树定义：a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
    // 根据高度平衡树的定义，我们得出满足定义需要以下三个条件：
    return Math.abs(height(root.left) - height(root.right)) < 2 //1. 检查当前根节点的左子树高度和右子树高度是否 <= 1 
        && isBalanced(root.left) //2. 检查左子树是否也平衡 （容易忘）
        && isBalanced(root.right); //3. 检查右子树是否也平衡 （容易忘）
    }

}


// @lc code=end

/* 

// 方法二：自底向上的递归
// Utility class to store information from recursive calls
final class TreeInfo {
    public final int height;
    public final boolean balanced;

    public TreeInfo(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

class Solution {
    // Return whether or not the tree at root is balanced while also storing
    // the tree's height in a reference variable.
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        // An empty tree is balanced and has height = -1
        if (root == null) {
        return new TreeInfo(-1, true);
        }

        // Check subtrees to see if they are balanced.
        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) {
        return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced) {
        return new TreeInfo(-1, false);
        }

        // Use the height obtained from the recursive calls to
        // determine if the current node is also balanced.
        if (Math.abs(left.height - right.height) < 2) {
        return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }

}

*/



/*
// 中文官网讨论区 自底向上的简便写法 
public boolean isBalanced(TreeNode root) {
    return helper(root) >= 0;
}

public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        int r = helper(root.right);

        if(l==-1 || r==-1 || Math.abs(l-r)>1) 
            return -1;

        return Math.max(l,r) +1;
    }

*/