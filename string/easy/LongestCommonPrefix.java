package string.easy;

/**
 * 14. 最长公共前缀
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        test();
    }

    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     *
     * 示例 2:
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     *
     * 解释: 输入不存在公共前缀。
     * 说明:
     * 所有输入只包含小写字母 a-z 。
     *
     * 相关标签
     * 字符串
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnmav1/
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        String[] strs = new String[]{"flower","flow","flight"};
        //String[] strs = new String[]{"abc","d","d"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    /**
     * 纵向扫描
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int len = strs[0].length();
        // 循环第一个字符串
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            // 循环比较strs数组中的第i个元素
            for (int j = 1; j < strs.length; j++) {
                // 以最短的字符串长度为准 || 如果当前串字符和下一个串字符不匹配，表示已经匹配到末尾
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        // 所有串都一样的情况
        return strs[0];
    }

    public static String longestCommonPrefix2(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0) {
            return result;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int len = strs[0].length();
        boolean no = false;
        // 循环第一个字符串
        for (int i = 0; i < len; i++) {
            // 循环比较strs数组中的第i个元素
            for (int j = 0; j < strs.length - 1; j++) {
                // 以最短的字符串长度为准
                if (i == strs[j + 1].length()) {
                    no = true;
                    break;
                }
                // 如果当前串字符和下一个串字符不匹配，表示已经匹配到末尾
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    no = true;
                    break;
                }
            }
            // no=true 表示已经匹配结束
            if (no) {
                // 第一次匹配就失败
                if (i == 0) {
                    return result;
                }
                // 获取长度
                return strs[0].substring(0, i);
            }
        }
        // 所有串都一样的情况
        return strs[0];
    }
}
