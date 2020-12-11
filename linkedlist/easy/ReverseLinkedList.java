package linkedlist.easy;

/**
 * 反转链表
 *
 * @author yclimb
 * @date 2020/12/3
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        test();
    }

    /**
     * 反转一个单链表。
     *
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void test() {
        ListNode head = null, tail = null;
        for (int i = 1; i <= 5; i++) {
            if (i == 1) {
                head = tail = new ListNode(1);
            } else {
                tail.next = new ListNode(i);
                tail = tail.next;
            }
        }
        //tail.next = null;
        /*while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }*/
        ListNode result = reverseList1(head);
        //ListNode result = reverseList2(head);
        while (result != null) {
            System.out.println("result:" + result.val);
            result = result.next;
        }
    }

    /**
     * 单链表
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 迭代
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    /**
     * 递归
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
