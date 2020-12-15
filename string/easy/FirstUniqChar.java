package string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        test();
    }

    /**
     * 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 示例：
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     *  
     * 提示：你可以假定该字符串只包含小写字母。
     *
     * 相关标签
     * 哈希表
     * 字符串
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn5z8r/
     * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        String s = "loveleetcode";
        int result = firstUniqChar(s);
        System.out.println(result);
    }

    /**
     * 使用 hash 表方式
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        char[] strs = s.toCharArray();
        for (char str : strs) {
            // 将字符和重复次数存入 hash 表
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        // 循环字符数组，如果字符在 hash 表中重复次数 ==1，则表示唯一
        for (int i = 0; i < strs.length; i++) {
            if (map.get(strs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
