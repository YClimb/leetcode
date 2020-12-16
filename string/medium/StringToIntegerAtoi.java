package string.medium;

/**
 * 8. 字符串转换整数 (atoi)
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        test();
    }

    /**
     * 字符串转换整数 (atoi)
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     *
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     *
     * 提示：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *  
     *
     * 示例 1:
     *
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     *
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     *
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     *
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     * 示例 5:
     *
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     *
     * 相关标签
     * 数学
     * 字符串
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnoilh/
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        String s = "-1d231dddd";
        int result = myAtoi(s);
        //int result = myAtoi2(s);
        System.out.println(result);
    }

    /**
     * if 判断筛选
     */
    public static int myAtoi(String s) {
        // 空字符串直接返回0
        if (s == null) {
            return 0;
        }
        // 之后空字符串返回0
        if (s.length() == 0) {
            return 0;
        }
        // 去掉左右侧空格
        s = s.replaceAll("^[ ]+", "").trim();
        // "-/+/0-9"判断，确定边界
        char a = s.charAt(0);
        if (!Character.isDigit(a) && a != '-' && a != '+') {
            return 0;
        }
        //
        // 从头开始循环
        StringBuilder tmp = new StringBuilder();
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                if ("-".equals(String.valueOf(c))) {
                    negative = true;
                    continue;
                } else if ("+".equals(String.valueOf(c))) {
                    // 如果是"+"直接返回
                    continue;
                }
            }
            // 是否数字
            if (Character.isDigit(c)) {
                tmp.append(c);
            } else {
                break;
            }
        }
        // 无长度，表示格式不正确
        if (tmp.length() == 0) {
            return 0;
        }
        // 因为会大雨int的最大最小值，所以用 long 来存储
        long result = Long.parseLong(tmp.toString());
        if (negative) {
            result = result * -1;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    /**
     * 确定有限状态机（deterministic finite automaton, DFA）
     */
    public static int myAtoi2(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        int ans = 0;
        boolean neg = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int tmp = ((neg ? Integer.MIN_VALUE : Integer.MIN_VALUE + 1) + (str.charAt(i) - '0')) / 10;
            if (tmp > ans) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 - (str.charAt(i++) - '0');
        }
        return neg ? ans : -ans;
    }
}
