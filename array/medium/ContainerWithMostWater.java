package array.medium;

/**
 * 11. 盛最多水的容器
 *
 * @author yclimb
 * @date 2021/1/8
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        test();
    }

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     *
     * 输入：height = [1,1]
     * 输出：1
     * 示例 3：
     *
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     * 示例 4：
     *
     * 输入：height = [1,2,1]
     * 输出：2
     *  
     *
     * 提示：
     *
     * n = height.length
     * 2 <= n <= 3 * 104
     * 0 <= height[i] <= 3 * 104
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int n = maxArea(height);
        System.out.println(n);
    }

    public static int maxArea(int[] height) {
        // f=first,l=last
        int f = 0, l = height.length - 1;
        // 最大的结果
        int max = 0;
        // 双指针方式
        while (f < l) {
            int tmp;
            // 如果前面小，则需要以f为基准，乘以 l-f 之间的空位，取结果
            if (height[f] <= height[l]) {
                tmp = height[f] * (l - f);
                // 下标向前移动
                f++;
            } else {
                // 反之，以l为基准
                tmp = height[l] * (l - f);
                // 下标向后移动
                l--;
            }
            // 最大值计算
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

}
