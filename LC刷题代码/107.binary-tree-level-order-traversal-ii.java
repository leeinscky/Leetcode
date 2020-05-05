import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.TreeNode;

/* tree | breadth-first-search
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
// DFS：
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null)
            return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
*/



/* BFS：
java Queue中 的一些方法：
 * offer       添加一个元素并返回true        如果队列已满，则返回false
 * poll         移除并返问队列头部的元素     如果队列为空，则返回null
 * peek       返回队列头部的元素              如果队列为空，则返回null
 * put         添加一个元素                       如果队列满，则阻塞 
 * take       移除并返回队列头部的元素    
 * 
 * 原文链接：https://blog.csdn.net/u012050154/article/details/60572567
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if (root == null)
            return wrapList;

        queue.offer(root);
        //System.out.println("queue" + queue);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();

            for (int i = 0; i < levelNum; i++) {

                if ( queue.peek().left != null)
                    queue.offer( queue.peek().left );
                    System.out.println("queue.peek().left.val" + queue.peek().left.val);

                if ( queue.peek().right != null)
                    queue.offer( queue.peek().right );
                    System.out.println("queue.peek().right.val" + queue.peek().right.val);

                subList.add(queue.poll().val);
                System.out.println("subList" + Arrays.toString(subList.toArray() ) );

            }
            wrapList.add(0, subList);
            System.out.println("wrapList" + Arrays.toString(wrapList.toArray()));

        }
        return wrapList;
    }
}


// @lc code=end

