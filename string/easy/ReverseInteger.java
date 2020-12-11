package string.easy;

/**
 * 整数反转
 *
 * @author yclimb
 * @date 2020/12/11
 */
public class ReverseInteger {
    public static void main(String[] args) {
        test();
    }

    /**
     * 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     * 示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnx13t/
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void test() {
        int n = 123;
        System.out.println(reverseInteger(n));
        int n2 = -123;
        System.out.println(reverseInteger(n2));
        int n3 = 120;
        System.out.println(reverseInteger(n3));
    }

    public static int reverseInteger(int x) {
        int ans = 0;
        while (x != 0) {
            // 获取最后一位
            int pop = x % 10;
            // 判断是否超出范围
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            // 当前数 * 10 = 向上十进位 + pop = 十进位之后个位数位置
            ans = ans * 10 + pop;
            // 向下进位，123 变为 12，去掉个位
            x /= 10;
        }
        return ans;
    }
}
