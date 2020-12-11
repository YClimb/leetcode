package linkedlist.medium;

/**
 * 两数相加
 *
 * @author yclimb
 * @date 2020/12/2
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        test();
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvw73v/
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = addTwoNumbers(l1, l2);
        while (null != result) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 单链表
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位，相加>10的进位，比如5+6=11，进位1
        int carry = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            // l1 的值
            int n1 = l1 == null ? 0 : l1.val;
            // l2 的值
            int n2 = l2 == null ? 0 : l2.val;
            // 获取 l1+l2+进位的总和，进位是前一步循环赋值，第一次默认0
            int sum = n1 + n2 + carry;
            // 设置返回链表头
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                // 设置链表具体数据，每次追加 next 并将 tail 刷新为两级链表
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            // 获取向上进位值
            carry = sum / 10;
            // 循环赋值
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 当最后一进位时，可将数据放入单链表
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
