package string.easy;

/**
 * 125. 验证回文串
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        test();
    }

    /**
     * 验证回文串
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     *
     * 相关标签
     * 双指针
     * 字符串
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xne8id/
     * 链接：https://leetcode-cn.com/problems/valid-palindrome/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
        //boolean result = isPalindrome(s);
        boolean result = isPalindrome2(s);
        System.out.println(result);
    }

    /**
     * for 循环 首尾比较方法
     */
    public static boolean isPalindrome(String s) {
        // 空字符串也是回文字符串
        if (s == null) {
            return false;
        }
        // 不区分大小写和除数组+字母之外的字符不参与计算
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int len = s.length();
        // 如果只有一个字符，那么是回文字符串
        if (len == 0 || len == 1) {
            return true;
        }
        for (int i = 0; i < len / 2; i++) {
            // 首尾互相比较，如果不相等，则不是回文字符串
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针首尾比较
     */
    public static boolean isPalindrome2(String s) {
        // 空字符串也是回文字符串
        if (s == null) {
            return false;
        }
        // 不区分大小写和除数组+字母之外的字符不参与计算
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int len = s.length();
        // 如果只有一个字符，那么是回文字符串
        if (len == 0 || len == 1) {
            return true;
        }
        // 双指针首尾比较
        int l = 0, r = len - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
