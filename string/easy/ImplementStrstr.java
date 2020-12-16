package string.easy;

/**
 * 28. 实现 C 语言的 strstr() 以及 Java 的 indexOf()
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        test();
    }

    /**
     * 实现 C 语言的 strstr() 以及 Java 的 indexOf()
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     *
     * 示例 2:
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     *
     * 说明:
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     * 相关标签
     * 双指针
     * 字符串
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnr003/
     * 链接：https://leetcode-cn.com/problems/implement-strstr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        //String haystack = "hello", needle = "ll";
        String haystack = "mississippi", needle = "issip";
        int result = strStr(haystack, needle);
        System.out.println(result);
    }

    /**
     * 双指针模式
     */
    public static int strStr(String haystack, String needle) {
        // 当 needle 是空字符串时我们应当返回 0。
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        // h.len < n.len
        if (haystack.length() < needle.length()) {
            return -1;
        }
        // 循环 haystack，对比 needle
        int l = 0, r = 0, len = haystack.length(), nlen = needle.length();
        for (int i = 0; i < len; i++) {
            char c = haystack.charAt(i);
            // n 在 h 中第一个匹配到的字符位置
            if (c == needle.charAt(r)) {
                // 开始匹配，只要后移一位则表示不是第一次
                if (r == 0) {
                    l = i;
                }
                r++;
                // 如果当前长度就是最长，直接退出
                if (r == nlen) {
                    break;
                }
            } else {
                // 错误一次直接清空从i - r处开始匹配，因为可能遇到 haystack = "mississippi", needle = "issip" 情况
                if (r > 0) {
                    i = i - r;
                    l = r = 0;
                }
            }
        }
        if (r > 0 && r == nlen) {
            return l;
        }
        return -1;
    }

    /**
     * 子串逐一比较
     */
    public static int strStr2(String haystack, String needle) {
        int l = needle.length(), n = haystack.length();
        for (int start = 0; start < n - l + 1; ++start) {
            if (haystack.substring(start, start + l).equals(needle)) {
                return start;
            }
        }
        return -1;
    }
}
