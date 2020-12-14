package array.easy;

/**
 * 66. 加一
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class PlusOne {
    public static void main(String[] args) {
        test();
    }

    /**
     * 加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * 示例 2：
     *
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     * 示例 3：
     *
     * 输入：digits = [0]
     * 输出：[1]
     *  
     *
     * 提示：
     *
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     * 相关标签
     * 数组
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2cv1c/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        //int[] nums = new int[]{9,9,9};
        int[] nums = new int[]{1,2,3};
        //int[] result = plusOne1(nums);
        int[] result = plusOne2(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 最基础从后往前推
     */
    public static int[] plusOne1(int[] digits) {
        int num = digits[digits.length - 1] + 1;
        if (num < 10) {
            digits[digits.length - 1] = num;
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (num >= 10) {
                digits[i] = num % 10;
                if (i - 1 >= 0) {
                    num = digits[i - 1] = digits[i - 1] + 1;
                }
            }
        }
        if (num >= 10) {
            /*int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;*/
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
        return digits;
    }

    /**
     * 优化版：如果+1>10，则%10=0，否则<10直接返回
     */
    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 如果+1>10，则%10=0
            digits[i]++;
            digits[i] = digits[i] % 10;
            // 否则<10直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 999情况，999+1=1000，数组长度默认增加一位，后面肯定都是0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
