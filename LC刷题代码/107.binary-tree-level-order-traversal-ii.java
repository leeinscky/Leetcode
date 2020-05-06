import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.TreeNode;

/*
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
public class Solution { //DFS
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

        queue.offer(root); //root其实是3
        System.out.println("root: " + root.val);

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();

            for (int i = 0; i < levelNum; i++) {

                if ( queue.peek().left != null)
                    queue.offer( queue.peek().left );
                    //System.out.println("queue.().left.val: " + queue.peek().left.val);

                if ( queue.peek().right != null)
                    queue.offer( queue.peek().right );
                    //System.out.println("queue.peek().right.val: " + queue.peek().right.val);

                subList.add(queue.poll().val);
                System.out.println("subList: " + Arrays.toString(subList.toArray() ) );

            }
            wrapList.add(0, subList); //因为我们想让新加的sublist 放在列表坐起第0个位置，所以我们要加一个参数0.
            System.out.println("wrapList: " + Arrays.toString(wrapList.toArray()));

        }
        return wrapList;
    }
}


// @lc code=end


/*

Your Input
[3,9,20,null,null,15,7]

Stdout
root: 3
' +
  'queue.peek().left.val: 9
' +
  'queue.peek().right.val: 20
' +
  'subList: [3]
' +
  'wrapList: [[3]]


Finished
Your Input
[3,9,20,null,null,15,7]

Output (6 ms)
[[15,7],[9,20],[3]]

Expected Answer
[[15,7],[9,20],[3]]

Stdout
root: 3
' +
  'subList: [3]
' +
  'wrapList: [[3]]
' +
  'subList: [9]
' +
  'subList: [9, 20]
' +
  'wrapList: [[9, 20], [3]]
' +
  'subList: [15]
' +
  'subList: [15, 7]
' +
  'wrapList: [[15, 7], [9, 20], [3]]


*/
