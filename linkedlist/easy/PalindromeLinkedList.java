package linkedlist.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 *
 * @author yclimb
 * @date 2020/12/21
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        test();
    }

    /**
     * 回文链表
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     *
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     *
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * 相关标签
     * 链表
     * 双指针
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        ListNode head = null, tail = null;
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                head = tail = new ListNode(i);
                continue;
            }
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        System.out.println(isPalindrome(head));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 使用数组来判断
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 将链表值顺序转换为数组
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        // 判断数组是否是回文
        for (int i = 0; i < result.size() / 2; i++) {
            if (!result.get(i).equals(result.get(result.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
