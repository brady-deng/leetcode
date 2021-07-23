/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/7/22
 **/
public class L138 {
    public RandomNode copyRandomList(RandomNode head) {
        if (head != null) {

            RandomNode res = new RandomNode(head.val);
            RandomNode tmpRes = res;
            RandomNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
                tmpRes.next = new RandomNode(cur.val);
                tmpRes = tmpRes.next;
            }
            cur = head;
            tmpRes = res;
            while (cur != null) {
                RandomNode tmp = cur.random;
                RandomNode reItem = head;
                RandomNode reItemRes = res;
                if (tmp != null) {
                    while (reItem != null) {
                        if (reItem == tmp) {
                            tmpRes.random = reItemRes;
                        }
                        reItem = reItem.next;
                        reItemRes = reItemRes.next;
                    }
                }
                cur = cur.next;
                tmpRes = tmpRes.next;
            }
            return res;
        }
        else {
            return null;
        }
    }
}
