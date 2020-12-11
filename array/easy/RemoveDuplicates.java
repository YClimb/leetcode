package array.easy;

/**
 * 删除排序数组中的重复项
 *
 * @author yclimb
 * @date 2020/12/3
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void test1() {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(result);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int removeDuplicates(int[] nums) {
        // 判断数组长度
        if (nums.length == 0) {
            return 0;
        }
        // 使用双指针方式，i 表示左指针(新数组)，j 表示右指针(旧数组)
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // 判断 i 指针和 j 指针是否相等，如果不相等，则表示 j > i，需要替换 i 的值并 i++
            if (nums[i] != nums[j]) {
                // i++ 先执行，因为 i 的位置已经有值
                i++;
                nums[i] = nums[j];
            }
        }
        // i 是下标，从0开始，所以长度=i+1
        return i + 1;
    }
}
