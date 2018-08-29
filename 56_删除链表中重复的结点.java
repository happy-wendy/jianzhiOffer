//01
//若{1,2,3,3,4,4,5}输出为{1,2,5}
public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null) return pHead;
        ListNode root = new ListNode(-1);
        root.next = pHead;
        ListNode cur = pHead;
        ListNode pre = root;
        while(cur != null && cur.next != null){
            ListNode next = cur.next;
            if(cur.val == next.val){
                while(next != null && cur.val == next.val){//这样来跳过反复出现的某个重复项
                    next = next.next;
                }
                pre.next = next;
                cur = next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return root.next;
    }
    //变式:给定排序的链表，删除重复元素，只保留重复元素第一次出现的结点
    //eg:若{1,2,3,3,4,4,5}输出为{1,2,3,4,5}
    //两个指针分别指向链表的第一个结点及第二个结点，即 pre 指向第一个结点、cur 指向第二个结点；
    //若 pre.value == cur.value，则 pre 的 next 指向 cur 的 next ，cur 指向 cur 的 next ；
    //若不等，则 pre 指向 cur，cur 指向 cur 的 next；直到循环结束；
    //若是未排序的链表，则先排序再进行重复结点的删除；

    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode pre = pHead.next;
        ListNode cur;
        while(pre != null){
            cur = pre.next;
            if(cur != null && (pre.val == cur.val)){
                pre.next = cur.next;
            }
            else{
                pre = cur;
            }
        }
        return pHead;
    }
