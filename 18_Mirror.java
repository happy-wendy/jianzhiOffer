//我写的AC，但是没有考虑边界，temp的定义也不完美；
public class Solution {
    public void Mirror(TreeNode root) {
        TreeNode temp = new TreeNode(0);//
        if(root!=null){
            temp = root.left; //
            root.left = root.right;
            root.right = temp;
            if(root.left!=null)
                Mirror(root.left);
            if(root.right!=null)
                Mirror(root.right);
        }
    }
}

public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
         
        TreeNode pTemp = root.left;//这样定义temp比较好
        root.left = root.right;
        root.right = pTemp;
         
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }
