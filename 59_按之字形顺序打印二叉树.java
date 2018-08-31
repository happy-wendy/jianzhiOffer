//01用栈
//两个栈，奇数栈有值时（一个个出栈，先左后右放入偶数站）；偶数栈有值时（一个个出栈，先右后左放入奇数站）
//用两个list分别存放单数行和偶数行；栈的判空是s1.empty()；list的判空是list.isEmpty()
import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        int layer = 1;
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        while(!s1.empty() || !s2.empty()){
            if(layer % 2 != 0){
                ArrayList<Integer> list = new ArrayList<>();
                while(!s1.empty()){
                    TreeNode node = s1.pop();
                    if(node != null){
                        list.add(node.val);
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if(!list.isEmpty()){
                    listAll.add(list);
                    layer++;
                }
                
            }
            else{//双数行
                ArrayList<Integer> list = new ArrayList<Integer>();
                while(!s2.empty()){//栈不为空就弹出来存入list
                    TreeNode node = s2.pop();
                    if(node!=null){
                        list.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if(!list.isEmpty()){//list不为空，存入listAll
                    listAll.add(list);
                    layer++;
                }
            }
        }
        return listAll;
    }
}
//02用队列
//利用Java中的LinkedList的底层实现是双向链表的特点。
//1)可用做队列,实现树的层次遍历;2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    if (pRoot == null) {
        return ret;
    }
    ArrayList<Integer> list = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(null);//层分隔符
    queue.addLast(pRoot);
    boolean leftToRight = true;
     
    while (queue.size() != 1) {
        TreeNode node = queue.removeFirst();
        if (node == null) {//到达层分隔符
            Iterator<TreeNode> iter = null;
            if (leftToRight) {
                iter = queue.iterator();//从前往后遍历
            } else {
                iter = queue.descendingIterator();//从后往前遍历
            }
            leftToRight = !leftToRight;
            while (iter.hasNext()) {
                TreeNode temp = (TreeNode)iter.next();
                list.add(temp.val);
            }
            ret.add(new ArrayList<Integer>(list));
            list.clear();
            queue.addLast(null);//添加层分隔符
            continue;//一定要continue
        }
        if (node.left != null) {
            queue.addLast(node.left);
        }
        if (node.right != null) {
            queue.addLast(node.right);
        }
    }
     
    return ret;
}
