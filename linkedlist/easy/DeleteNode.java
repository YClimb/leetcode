package linkedlist.easy;

/**
 * 237. 删除链表中的节点
 *
 * @author yclimb
 * @date 2020/12/17
 */
public class DeleteNode {
    public static void main(String[] args) {
        test();
    }

    /**
     * 删除链表中的节点
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     *
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     * 示例 1：
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * 示例 2：
     * 输入：head = [4,5,1,9], node = 1
     * 输出：[4,5,9]
     * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     * 提示：
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     *
     * 相关标签
     * 链表
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnarn7/
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        // -- head = [1,2,3,4,5]
        ListNode head = null, tail = null;
        for (int i = 1; i <= 5; i++) {
            if (i == 1) {
                head = tail = new ListNode(1);
            } else {
                // 引用传递，此时 head 的 next = tail.next
                tail.next = new ListNode(i);
                // 默认赋空，此时 head 不变，tail = tail.next
                tail = tail.next;
            }
        }
        deleteNode(head, 3);
        // 循环输出
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void deleteNode(ListNode head, int node) {
        // 循环赋值，在方法内修改了值，在方法外也会修改
        while (head != null) {
            if (head.val == node) {
                head.val = head.next.val;
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
