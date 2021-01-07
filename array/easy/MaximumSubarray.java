package array.easy;

/**
 * 53. 最大子序和
 *
 * @author yclimb
 * @date 2021/1/7
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        test();
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int n = maxSubArray(nums);
        System.out.println(n);
    }

    /**
     * 贪心算法
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0], sum = max;
        for (int i = 1; i < nums.length; i++) {
            // 依次求和，如果当前 sum < num[i], 则赋值为 num[i]
            sum = Math.max(nums[i], sum + nums[i]);
            // 只有 sum > max 时才会赋值
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 动态规划
     */
    public static int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
