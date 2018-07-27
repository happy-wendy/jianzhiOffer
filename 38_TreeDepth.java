//递归
//左子树有右无，则左加一；左右子树皆有，则大的加一
import java.lang.Math;
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
//循环（层次遍历：广度）
import java.util.LinkedList;
import java.util.Queue;
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }                
            }
            depth ++;
        }
        return depth;
    }
}
