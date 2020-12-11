package string.easy;

/**
 * 反转字符串
 *
 * @author yclimb
 * @date 2020/12/3
 */
public class ReverseString {
    public static void main(String[] args) {
        test();
    }

    /**
     * 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     * 示例 1：
     *
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * 示例 2：
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     * 相关标签：双指针、字符串
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnhbqj/
     * 链接：https://leetcode-cn.com/problems/reverse-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public static void test() {
        String s = "hello";
        reverseString1(s.toCharArray());
        reverseString2(s.toCharArray());
    }

    /**
     * 使用首尾互换的方式，循环次数为长度的一半
     */
    public static void reverseString1(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
        /*for (char c : s) {
            System.out.println(c);
        }*/
    }

    /**
     * 双指针法，首尾互换
     */
    public static void reverseString2(char[] s) {
        int left = 0;
        int right = s.length - 1;
        for (; left < right; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
        /*for (char c : s) {
            System.out.println(c);
        }*/
    }
}
