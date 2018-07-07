//法一：
//只遍历链表一次就能找到倒数第k个结点，我们可以定义两个指针。第一个指针从链表的头指针开始遍历向前走k-1，第二个指针不动；
//从第k步开始，第二个指针也开始从链表头指针开始遍历。
//由于两个指针的距离保持在k-1，当第一个指针到达链表的尾结点时，第二个指针正好是倒数第k个结点。
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0)
            return null;
        ListNode first = head, second = head;
        while(k-1 != 0){
            if(first.next!=null)
                first = first.next;
            else{
                return null;
            }
            k--;
        }
        while(first.next!=null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
//法二：栈的思想
def FindKthToTail(self, head, k):
        # write code here
        res = []
        while head:
            res.append(head)
            head = head.next
        if k > len(res) or k < 1:
            return None
        return res[-k]
//假设链表有n个结点，倒数第k个，就是从头开始第n-k+1个结点，这个不难，遍历链表第一次得到结点个数n，遍历第二次得到第n-k+1个结点。
