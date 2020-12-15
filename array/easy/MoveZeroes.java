package array.easy;

/**
 * 283. 移动零
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class MoveZeroes {
    public static void main(String[] args) {
        test();
    }

    /**
     * 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * 相关标签
     * 数组
     * 双指针
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2ba4i/
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums = new int[]{0,1,0,3,12};
        //moveZeroes(nums);
        moveZeroes2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 双指针 for 循环
     */
    public static void moveZeroes(int[] nums) {
        // 双指针，l 表示>0数字下标，i 表示未排序位置
        int l = 0, i = 0;
        for (; i < nums.length; i++) {
            // 如果当前数字==0，继续往下执行
            if (nums[i] != 0) {
                // 当前!=0，则替换 l 下标的值，i 下标的值=0
                int tmp = nums[l];
                nums[l] = nums[i];
                nums[i] = tmp;
                l++;
            }
        }
    }

    /**
     * 双指针 while 循环
     */
    public static void moveZeroes2(int[] nums) {
        int len = nums.length, left = 0, right = 0;
        while (right < len) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }
}
