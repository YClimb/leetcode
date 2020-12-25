package string.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. 有效的括号
 *
 * @author yclimb
 * @date 2020/12/4
 */
public class ValidParentheses {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        /**
         * 有效的括号
         * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
         *
         * 有效字符串需满足：
         *
         * 左括号必须用相同类型的右括号闭合。
         * 左括号必须以正确的顺序闭合。
         * 注意空字符串可被认为是有效字符串。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnbcaj/
         * 链接：https://leetcode-cn.com/problems/valid-parentheses
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        //String s = "(){}[]";
        String s = "([()()()])";
        //boolean result = isValid(s);
        boolean result = isValid2(s);
        System.out.println(result);
    }

    /**
     * 消消乐
     */
    public static boolean isValid(String s) {
        // 空字符串有效
        if (s.isEmpty()) {
            return true;
        }
        int len = s.length();
        // 单数则肯定无效
        if (len % 2 != 0) {
            return false;
        }
        // 如果是有效的，肯定有一对初始括号，那么直接依次循环 len/2 次，消除括号对即可
        int i = len / 2;
        while (i > 0) {
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\{\\}", "");
            s = s.replaceAll("\\[\\]", "");
            // 消除完之后，如果长度==0，则表示成功
            if (s.length() == 0) {
                return true;
            }
            i--;
        }
        return false;
    }

    /**
     * 栈
     */
    public static boolean isValid2(String s) {
        // 空字符串有效
        if (s.isEmpty()) {
            return true;
        }
        int len = s.length();
        // 单数则肯定无效
        if (len % 2 != 0) {
            return false;
        }
        // 设置一个包含括号的Map
        Map<Character, Character> map = new HashMap<>(3);
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        // 设置一个栈
        Deque<Character> stack = new ArrayDeque<>(len);
        // 循环字符串
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                // 反括号匹配成功，移除栈
                stack.pop();
            } else {
                // 不匹配则写入栈
                stack.push(c);
            }
        }
        // 空栈则表示有效
        return stack.isEmpty();
    }
}
