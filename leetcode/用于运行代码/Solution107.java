import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if (root == null)
            return wrapList;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();

            for (int i = 0; i < levelNum; i++) {

                if ( queue.peek().left != null)
                    queue.offer( queue.peek().left );

                if ( queue.peek().right != null)
                    queue.offer( queue.peek().right );

                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        System.out.println(wrapList);
        return wrapList;
    }


    public static void main(String[] args){
        Solution107 newsol = new Solution107();
        TreeNode root = new TreeNode(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> result = newsol.levelOrderBottom(root);
        System.out.println(result);

    }



}
