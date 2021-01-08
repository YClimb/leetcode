package array.medium;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author yclimb
 * @date 2021/1/8
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        test();
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 进阶：
     *
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *  
     *
     * 提示：
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums = new int[]{5,7,7,8,8,10};
        /*int[] tmp = searchRange(nums, 8);
        System.out.println(Arrays.toString(tmp));*/
        int[] tmp2 = searchRange2(nums, 8);
        System.out.println(Arrays.toString(tmp2));
    }

    /**
     * 暴力循环
     */
    public static int[] searchRange(int[] nums, int target) {
        int f = -1, l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (f == -1) {
                    // 如果只有一位，第一位和最后一位都是本身
                    f = l = i;
                } else {
                    // 如果不是第一次，则每次给最后一位赋值
                    l = i;
                }
            }
        }
        return new int[]{f, l};
    }


    /**
     * 双指针模式
     */
    public static int[] searchRange2(int[] nums, int target) {
        int f = -1, l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (f == -1) {
                if (nums[i] == target) {
                    f = i;
                }
            }
            if (l == -1) {
                if (nums[nums.length - 1 - i] == target) {
                    l = nums.length - 1 - i;
                }
            }
            if (f > -1 && l > -1) {
                break;
            }
        }
        return new int[]{f, l};
    }
}
