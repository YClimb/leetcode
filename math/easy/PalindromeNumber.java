package math.easy;

/**
 * 9. 回文数
 *
 * @author yclimb
 * @date 2021/1/5
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        test();
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     *
     * 示例 1:
     *
     * 输入: 121
     * 输出: true
     * 示例 2:
     *
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     *
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     *
     * 你能不将整数转为字符串来解决这个问题吗？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static void test() {
        int x = 12321;
        boolean b = isPalindrome(x);
        System.out.println(b);
    }

    /**
     * 数学计算法，翻转数字的后一半，比较结果
     */
    public static boolean isPalindrome(int x) {
        // 如果小于0，或者末尾数字=0，则不是回文数字
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 翻转后的一半数字
        int revertedNumber = 0;
        // 如果 x 小于后一半数字，则继续翻转
        while (x > revertedNumber) {
            // 将数字的最后一位得出，追加在 revertedNumber 数字上
            // 12321
            // 1232 - 1
            // 123 - 12
            // 12 - 123
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 偶数相等，奇数需要 revertedNumber / 10
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
