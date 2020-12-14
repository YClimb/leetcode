package array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        test();
    }

    /**
     * 存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     *
     * 示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     *
     * 相关标签: 数组/哈希表
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
     * 链接：https://leetcode-cn.com/problems/contains-duplicate/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums = new int[]{1,2,3,1};
        //boolean l = containsDuplicate1(nums);
        boolean l = containsDuplicate2(nums);
        System.out.println(l);
    }

    /**
     * 使用 hash 来判定是否存在
     */
    public static boolean containsDuplicate1(int[] nums) {
        /*Map<Integer, Boolean> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, true);
        }*/
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用排序法，排序如果有相同的数，那么相临的两个数肯定相等
     */
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
