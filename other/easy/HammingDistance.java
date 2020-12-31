package other.easy;

/**
 * 461. 汉明距离
 *
 * @author yclimb
 * @date 2020/12/31
 */
public class HammingDistance {
    public static void main(String[] args) {
        test();
    }

    /**
     * 汉明距离
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     *
     * 注意：
     * 0 ≤ x, y < 231.
     *
     * 示例:
     *
     * 输入: x = 1, y = 4
     *
     * 输出: 2
     *
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     *
     * 上面的箭头指出了对应二进制位不同的位置。
     * 相关标签
     * 位运算
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnyode/
     * 链接：https://leetcode-cn.com/problems/hamming-distance/solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int x = 1, y = 4;
        int n = hammingDistance(x, y);
        System.out.println(n);
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 布赖恩·克尼根算法
     *
     * 当我们在 number 和 number-1 上做 AND 位运算时，原数字 number 的最右边等于 1 的比特会被移除。
     */
    public static int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }

    /**
     * 移位
     *
     * 思路：为了计算等于 1 的位数，可以将每个位移动到最左侧或最右侧，然后检查该位是否为 1。
     * 更准确的说，应该进行逻辑移位，移入零替换丢弃的位。
     */
    public static int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }
}
