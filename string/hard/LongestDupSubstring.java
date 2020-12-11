package string.hard;

import java.util.Arrays;

/**
 * 1044. 最长重复子串
 *
 * @author yclimb
 * @date 2020/12/1
 */
public class LongestDupSubstring {
    public static void main(String[] args) {
        test();
    }

    /**
     * 1044. 最长重复子串
     * 给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
     * 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
     *
     * 示例 1：
     * 输入："banana"
     * 输出："ana"
     *
     * 示例 2：
     * 输入："abcd"
     * 输出：""
     *
     * 提示：
     * 2 <= S.length <= 10^5
     * S 由小写英文字母组成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring/
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void test() {
        String s = "banana";
        String result = longestDupSubstring(s);
        System.out.println("result:" + result);
    }

    /**
     * 找出字符串中最长重复子串
     */
    public static String longestDupSubstring(String s) {
        // 获取所有子字符串
        int len = s.length();
        String[] sub = new String[len];
        for (int i = 0; i < s.length(); i++) {
            sub[i] = s.substring(i, len);
        }
        // 字典排序
        Arrays.sort(sub);
        // 最大的重复长度
        int maxLen = 0;
        // 最长的重复字符串
        String result = null;
        // 循环子字符串集合
        for (int i = 0; i < len - 1; i++) {
            // 子字符串依次比较
            String a = sub[i];
            String b = sub[i + 1];
            // 循环比较子字符串相同的字符有多少个
            int j = 0;
            /*for (; j < a.length(); j++) {
                if (j >= b.length()) {
                    break;
                }
                if (a.charAt(j) != b.charAt(j)) {
                    break;
                }
            }*/
            while (j < a.length() && j < b.length() && a.charAt(j) == b.charAt(j)) {
                j++;
            }
            // 获取两个字符串相同的字符个数，如果比当前最大个数大，则替换，记录最长重复字符串
            if (maxLen < j) {
                maxLen = j;
                result = a.substring(0, maxLen);
            }
        }
        return result;
    }
}
