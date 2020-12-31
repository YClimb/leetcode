package math.easy;

/**
 * 326. 3的幂
 *
 * @author yclimb
 * @date 2020/12/31
 */
public class PowerOfThree {
    public static void main(String[] args) {
        test();
    }

    /**
     * 3的幂
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
     *
     * 示例 1：
     *
     * 输入：n = 27
     * 输出：true
     * 示例 2：
     *
     * 输入：n = 0
     * 输出：false
     * 示例 3：
     *
     * 输入：n = 9
     * 输出：true
     * 示例 4：
     *
     * 输入：n = 45
     * 输出：false
     *
     * 提示：
     * -231 <= n <= 231 - 1
     *  
     *
     * 进阶：
     * 你能不使用循环或者递归来完成本题吗？
     *
     * 相关标签
     * 数学
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnsdi2/
     * 链接：https://leetcode-cn.com/problems/power-of-three/solution/3de-mi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int n = 3;
        boolean l = isPowerOfThree(n);
        System.out.println(l);
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
