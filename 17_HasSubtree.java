/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val)
                flag = doesTree1HaveTree2(root1, root2);
            if(!flag)
                flag = HasSubtree(root1.left, root2);
            if(!flag)
                flag = HasSubtree(root1.right, root2);
        }
        return flag;
    }
    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
//精简版
public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)
            return false;
        return doesTree1HaveTree2(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null || root1.val != root2.val)
            return false;
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
