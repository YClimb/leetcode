package array.easy;

/**
 * 27. 移除元素
 *
 * @author yclimb
 * @date 2021/1/6
 */
public class RemoveElement {
    public static void main(String[] args) {
        test();
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     *
     * 示例 1:
     *
     * 给定 nums = [3,2,2,3], val = 3,
     *
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     *
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     *
     * 注意这五个元素可为任意顺序。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *  
     *
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums = new int[]{3,2,2,3};
        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        //int len = removeElement(nums, 3);
        int len = removeElement2(nums, 3);
        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 双重循环模式
     */
    public static int removeElement(int[] nums, int val) {
        // 删除的元素个数，用于减少循环次数
        int len = 0;
        // 所有元素循环一遍
        for (int i = 0; i < nums.length - len; i++) {
            // 如果相等，需要将当前元素移动到最后
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1 - len; j++) {
                    nums[j] = nums[j + 1];
                    //nums[j + 1] = 0;
                }
                // 删除一个就减少一次循环
                len++;
                // 因为当前元素被覆盖，所以外层需要继续从当前元素开始循环
                i--;
            }
        }
        return nums.length - len;
    }

    /**
     * 双指针模式
     */
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
