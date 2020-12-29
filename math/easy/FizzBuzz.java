package math.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 *
 * @author yclimb
 * @date 2020/12/29
 */
public class FizzBuzz {
    public static void main(String[] args) {
        test();
    }

    /**
     * Fizz Buzz
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * 示例：
     *
     * n = 15,
     *
     * 返回:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xngt85/
     * 链接：https://leetcode-cn.com/problems/fizz-buzz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int n = 15;
        //List<String> list = fizzBuzz(n);
        List<String> list = fizzBuzz2(n);
        System.out.println(list.toString());
    }

    public static List<String> fizzBuzz(int n) {
        String f = "Fizz";
        String b = "Buzz";
        List<String> list = new ArrayList<>(n);
        StringBuilder tmp = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) {
                tmp.append(f);
            }
            if (i % 5 == 0) {
                tmp.append(b);
            }
            if (tmp.length() == 0) {
                tmp.append(i);
            }
            list.add(tmp.toString());
            tmp.setLength(0);
        }
        return list;
    }

    public static List<String> fizzBuzz2(int n) {
        String f = "Fizz";
        String b = "Buzz";
        String fb = "FizzBuzz";
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean b3 = (i % 3 == 0);
            boolean b5 = (i % 5 == 0);
            if (b3 && b5) {
                list.add(fb);
            } else if (b3) {
                list.add(f);
            } else if (b5) {
                list.add(b);
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
