package other.easy;

/**
 * 509. 斐波那契数
 *
 * @author yclimb
 * @date 2021/1/4
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        test();
    }

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n) 。
     *  
     *
     * 示例 1：
     *
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * 示例 2：
     *
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     * 示例 3：
     *
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     *  
     *
     * 提示：
     *
     * 0 <= n <= 30
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fibonacci-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static void test() {
        int n = 4;
        System.out.println(fib(n));
        System.out.println(fib2(n));
    }

    /**
     * 暴力破解
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 动态规划
     * https://leetcode-cn.com/problems/fibonacci-number/solution/fei-bo-na-qi-shu-by-leetcode-solution-o4ze/
     */
    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        // 用三个数来记录[前、中、后]数字，返回 n 次循环后的最后的一个数字即可
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
