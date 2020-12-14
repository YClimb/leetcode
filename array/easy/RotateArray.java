package array.easy;

/**
 * 旋转数组
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class RotateArray {
    public static void main(String[] args) {
        test();
    }

    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * 示例 2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     *
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        //rotate1(nums, 3);
        rotate2(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 双重for循环
     */
    public static void rotate1(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        // 从0-len
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        // 从len-0
        /*for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
            }
        }*/
    }

    /**
     * 使用新数组存储旋转，再赋值旧数组
     */
    public static void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        // 从头开始遍历，将所有数据插入新数组
        for (int i = 0; i < nums.length; i++) {
            // 新数组的下标值=旋转后的下标值
            a[(i + k) % nums.length] = nums[i];
        }
        // 将旋转后的新数组值赋值给旧数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
