package string.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class ValidAnagram {
    public static void main(String[] args) {
        test();
    }

    /**
     * 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * 相关标签
     * 排序
     * 哈希表
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn96us/
     * 链接：https://leetcode-cn.com/problems/valid-anagram/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        String s = "anagram", t = "nagaram";
        boolean l = isAnagram(s, t);
        System.out.println(l);
    }

    /**
     * 使用 hash 表方式
     */
    public static boolean isAnagram(String s, String t) {
        // 长度不一样，直接返回错误
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        // 设置两个 hash 表，map1-s,map2-t;
        Map<Character, Integer> map1 = new HashMap<>(len);
        Map<Character, Integer> map2 = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            // 存储 s/t 中每个字符的次数
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 比较字符次数是否一致，如果一致，则表示正确
        for (int i = 0; i < len; i++) {
            if (!map1.get(s.charAt(i)).equals(map2.get(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用排序的方式
     */
    public static boolean isAnagram2(String s, String t) {
        // 长度不一样，直接返回错误
        if (s.length() != t.length()) {
            return false;
        }
        // 字符数组排序
        char[] strs1 = s.toCharArray();
        char[] strs2 = t.toCharArray();
        Arrays.sort(strs1);
        Arrays.sort(strs2);
        /*for (int i = 0; i < strs1.length; i++) {
            if (strs1[i] != strs2[i]) {
                return false;
            }
        }
        return true;*/
        // 比较数组是否相同
        return Arrays.equals(strs1, strs2);
    }
}
