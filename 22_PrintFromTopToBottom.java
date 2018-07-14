//树的层次遍历/广度优先遍历：
//1. 先将根节点入队列 
//2. 将根节点出队列，打印；然后将其左右子树依次入队列（若其存在） 
//3. 重复步骤2，直到将树遍历完为止。
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> myQueue = new LinkedList<>();
        ArrayList<Integer> list= new ArrayList<>();
        if(root == null)
            return list;
        myQueue.offer(root);//.add()
        while(!myQueue.isEmpty()){
            TreeNode tempNode = myQueue.poll();//.remove()
            list.add(tempNode.val);
            if(tempNode.left != null){
                myQueue.offer(tempNode.left);
            }
            if(tempNode.right != null){
                myQueue.offer(tempNode.right);
            }            
        }
        return list;
    }
}
