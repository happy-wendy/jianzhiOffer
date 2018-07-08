/*
public class ListNode {
    int val;
    ListNode next = null;
 
    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode list3 = new ListNode(0);
        ListNode pointer = list3;
        while(list1 !=null && list2 != null){
            if(list1.val < list2.val){
                pointer.next = list1;           
                list1 = list1.next;
            }
            else{
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }
        if(list1 != null)
            pointer.next = list1;
        if(list2 != null)
            pointer.next = list2;
        return list3.next;
    }
}
//法二：递归(简洁)
public ListNode Merge(ListNode list1,ListNode list2) {
       if(list1 == null){
           return list2;
       }
       if(list2 == null){
           return list1;
       }
       if(list1.val <= list2.val){
           list1.next = Merge(list1.next, list2);
           return list1;
       }else{
           list2.next = Merge(list1, list2.next);
           return list2;
       }       
   }
//法三：python
class Solution:
    # 返回合并后列表
    def Merge(self, pHead1, pHead2):
        # write code here
        p = merge = ListNode(0)
        while pHead1 and pHead2:
            if pHead1.val > pHead2.val:
                merge.next = pHead2
                pHead2 = pHead2.next
            elif pHead2.val >= pHead1.val:
                merge.next = pHead1
                pHead1 = pHead1.next
            merge = merge.next
        #merge.next = pHead1 if pHead1 else pHead2
        merge.next = pHead1 or pHead2
        return p.next
