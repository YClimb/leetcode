package linkedlist.easy;

/**
 * 21. 合并两个有序链表
 *
 * @author yclimb
 * @date 2020/12/21
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        test();
    }

    /**
     * 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 相关标签
     * 链表
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnnbp2/
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        ListNode head1 = null, tail1 = null;
        ListNode head2 = null, tail2 = null;
        for (int i = 1; i < 4; i++) {
            if (i == 1) {
                head1 = tail1 = new ListNode(i);
                head2 = tail2 = new ListNode(i);
                continue;
            }
            tail1.next = new ListNode(i);
            tail1 = tail1.next;
            tail2.next = new ListNode(i);
            tail2 = tail2.next;
        }
        ListNode tmp = mergeTwoLists(head1, head2);
        //ListNode tmp = mergeTwoLists1(head1, head2);
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 迭代
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode tmp = result;
        while (l1 != null && l2 != null) {
            // 如果小于当前值，则当前向下迭代一个，另一个不变
            if (l1.val <= l2.val) {
                tmp.next = new ListNode(l1.val);
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l2.val);
                tmp = tmp.next;
                l2 = l2.next;
            }
            // 如果是最后一个值，那么直接赋值即可
            if (l1 == null) {
                tmp.next = l2;
                break;
            } else if (l2 == null) {
                tmp.next = l1;
                break;
            }
        }
        return result.next;
    }

    /**
     * 递归
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
