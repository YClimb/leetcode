package array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class SingleNumber {
    public static void main(String[] args) {
        test();
    }

    /**
     * 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     *
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     *
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * 相关标签
     * 位运算
     * 哈希表
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x21ib6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums = new int[]{4,1,2,1,2};
        //int result = singleNumber(nums);
        int result = singleNumber2(nums);
        System.out.println(result);
    }

    /**
     * 使用 hash 方式
     */
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }

    /**
     * 使用 异或位运算 方式
     */
    public static int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
