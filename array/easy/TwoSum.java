package array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author yclimb
 * @date 2020/12/2
 */
public class TwoSum {
    public static void main(String[] args) {
        test();
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2jrse/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void test() {
        int[] nums = new int[]{-3,4,3,90};
        int target = 0;
        int[] result = twoSum1(nums, target);
        //int[] result = twoSum2(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int tmp = target - n;
            if (i > 0 && map.containsKey(tmp)) {
                result[0] = map.get(tmp);
                result[1] = i;
                break;
            }
            map.put(n, i);
        }
        return result;
    }

}
