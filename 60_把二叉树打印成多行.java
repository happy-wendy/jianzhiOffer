//01用队列，在层序遍历上作些微更改
import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.Queue;

/*
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(pRoot == null){
            return listAll;
        }
        TreeNode cur = pRoot;
        queue.offer(cur);
        int count;
        int perLayer;
        while(!queue.isEmpty()){
            count = 0;
            perLayer = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(count < perLayer){
                cur = queue.poll();
                list.add(cur.val);
                count++;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            listAll.add(list);
        }
        return listAll;
    }
}
//02用递归
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }
     
    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.val);
         
        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}
