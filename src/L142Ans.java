/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/23
 **/
public class L142Ans {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){return null;}
        //initialise slow and fast pointers to head
        ListNode slow=head;
        ListNode fast=head;
        //iterate till null appears and slow ==fast pointer
        while(slow!=null&&fast!=null&&fast.next!=null){
            //slow will do a single jump
            slow=slow.next;
            //fast will do a double jump
            fast=fast.next.next;
            //break when slow==fast
            if(slow==fast)break;
        }
        //if slow!=fast return null as there is no loop
        if(slow!=fast) {
            return null;
        }
        //now initalise slow to head again
        slow=head;
        //now both slow and fast will do a single jump until slow==fast then break
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        //now you can return slow or fast as booth are same
        return slow;
    }
}
