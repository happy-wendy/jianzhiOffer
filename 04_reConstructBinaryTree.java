/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //法一
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length <= 0 || in.length <=0 || pre.length != in.length)
            return null;
        int len = pre.length;
        return constructCore(pre, in, 0, len - 1, 0, len - 1);
    }
    public static TreeNode constructCore(int[] pre,int[] in,int preStart,int preEnd,int inStart,int inEnd){
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = null;
        root.right = null;
        if(preStart == preEnd){
            if(inStart == inEnd && pre[preStart] == in[inStart]){
                return root;
            }
            else{//如果输入错误，前序遍历和中序遍历结果不一致，则报错
                System.out.println("Wrong input");
                return null;
            }
        }
        int i = inStart;
        for(; i<=inEnd; i++){
            if(in[i] == pre[preStart])
                break;
        }
        //如果输入错误，前序遍历和中序遍历结果不一致，则报错
        if(i == inEnd & in[i] != pre[preStart]){
            System.out.println("Wrong input");
            return null;
        }
        int leftLen = i - inStart;
        if(leftLen > 0){
            root.left = constructCore(pre, in, preStart+1, preStart + leftLen, inStart, i-1);
        }
        if(inEnd - i > 0){
            root.right = constructCore(pre, in, preStart+leftLen+1, preEnd, i+1, inEnd);
        }
        return root;
    }
}
//法二
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[]in, int startIn, int endIn){
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = startIn; i<=endIn; i++)
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTree(pre, startPre+1, startPre+i-startIn, in, startIn, i-1);
                root.right = reConstructBinaryTree(pre, i-startIn+startPre+1, endPre, in, i+1, endIn);
            }
        return root;
    }
}
//法三
#!/usr/bin/env python3
# -*- coding: utf-8 -*-
class Node:
  def __init__(self, data, left, right):
    self.data = data
    self.left = left
    self.right = right
def construct_tree(pre_order, mid_order):
  # 
  if len(pre_order) == 0 or len(mid_oder) ==0 :
    return None
  # 前序遍历的第一个结点一定是根结点
  root_data = pre_order[0]
  for i in range(0, len(mid_order)):
    if mid_order[i] == root_data:
      break
  # 递归构造左子树和右子树
  left = construct_tree(pre_order[1 : 1 + i], mid_order[:i])
  right = construct_tree(pre_order[1 + i:], mid_order[i+1:])
  return Node(root_data, left, right)
if __name__ == '__main__':
  pre_order = [1, 2, 4, 7, 3, 5, 6, 8]
  mid_order = [4, 7, 2, 1, 5, 3, 8, 6]
  root = construct_tree(pre_order, mid_order)
  
  //极简python
  class Solution:
    # 返回构造的TreeNode根节点
    def reConstructBinaryTree(self, pre, tin):
        # write code here
        if len(pre) == 0:
            return None
        if len(pre) == 1:
            return TreeNode(pre[0])
        else:
            res = TreeNode(pre[0])
            res.left = self.reConstructBinaryTree(pre[1: tin.index(pre[0])+1], tin[: tin.index(pre[0])])
            res.right = self.reConstructBinaryTree(pre[tin.index(pre[0])+1:], tin[tin.index(pre[0])+1:])
        return res
