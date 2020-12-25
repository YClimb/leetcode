package other.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 268. 丢失的数字
 *
 * @author yclimb
 * @date 2020/12/25
 */
public class MissingNumber {
    public static void main(String[] args) {
        test();
    }

    /**
     * 缺失数字
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     *
     *  
     * 进阶：
     * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [3,0,1]
     * 输出：2
     * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：2
     * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 3：
     *
     * 输入：nums = [9,6,4,2,3,5,7,0,1]
     * 输出：8
     * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
     * 示例 4：
     *
     * 输入：nums = [0]
     * 输出：1
     * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
     *  
     *
     * 提示：
     *
     * n == nums.length
     * 1 <= n <= 104
     * 0 <= nums[i] <= n
     * nums 中的所有数字都 独一无二
     *
     * 相关标签
     * 位运算
     * 数组
     * 数学
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnj4mt/
     * 链接：https://leetcode-cn.com/problems/missing-number/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1};
        //int n = missingNumber(nums);
        //int n = missingNumber2(nums);
        //int n = missingNumber3(nums);
        int n = missingNumber4(nums);
        System.out.println(n);
    }

    /**
     * 排序
     */
    public static int missingNumber(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        int len = nums.length;
        // 如果最大数!=长度，表示缺失了最大数
        if (len != nums[len - 1]) {
            return nums[len - 1] + 1;
        }
        // 比较相邻的数字，如果差值>1表示他两中间的数字就是缺失的值
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i + 1] - 1;
            }
        }
        return 0;
    }

    /**
     * 异或
     */
    public static int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * 数学
     */
    public static int missingNumber3(int[] nums) {
        int len = nums.length;
        int total = (1 + len) * len / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }


    /**
     * 哈希
     */
    public static int missingNumber4(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i <= len; i++) {
            map.put(i, i);
        }
        for (int num : nums) {
            map.remove(num);
        }
        return map.values().iterator().next();
    }
}
