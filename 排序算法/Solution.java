class Tetst {

    int[] sum;

    Random random;
    
    public Solution(int[] w) {
        random = new Random();
        sum = new int([w.length]*1000);
        
        sum[0] = w[0];
        for(int i=1; i < w.length; i++){
            sum[i] = sum[i-1] + w[i];
        }
        
        int value = random.nextInt(sum[sum.length - 1]) + 1; // 从0-sum[sum.length-1]+1随机生成一个随机数
    
    }

    class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> views;
        scan(root, 0, views);
        return views;
     }
private:

    void scan(TreeNode* root, int h, vector<int>& views)
    {
        if(!root)   return;
        if(h >= views.size())
            views.emplace_back(root->val);
        /* 先遍历右侧，这样就可以先选择右边的元素 */
        scan(root->right, h + 1, views);
        scan(root->left, h + 1, views);
    }
}




public static int compute(int step) { 
    if (step == 0) { 
        return 1;
    } else if (step < 0) { 
        return 0;
    } else { 
        int result1 = compute(step - 1);
        int result2 = compute(step - 2);
        int allResult = result1 + result2;
        return allResult;
    }
}


//因为对于二叉搜索树来说，中序遍历可以输出有序的序列，所以只需按中序遍历，同时记录前一个节点的值，比较更新最小值即可。

public class Test {

    int current = Integer.MIN_VALUE, result;

    public int minDiffInBST(TreeNode root) {
        if (root == null) 
            return 0;
        
        int result = Integer.MAX_VALUE;
        
        inorder(root);
        
        return result;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        
        int distance = Math.abs(current - root.val);
        
        if (current != Integer.MIN_VALUE) {
            result = Math.min(result, distance);
        }
        
        current = root.val;
        
        inorder(root.right);
    }


}

