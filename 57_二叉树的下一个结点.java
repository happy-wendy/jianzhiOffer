//画图：然后分出三种情况
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null) return null;
        if(pNode.right != null){//如果有右子树，则找右子树的最左节点
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        while(pNode.next != null){//没右子树，则找第一个当前节点是父节点左孩子的节点
            if(pNode.next.left == pNode){
                return pNode.next;//是左孩子
            }
            pNode = pNode.next;//是右孩子
        }
        return null;//退到了根节点仍没找到，则返回null
    }
}
