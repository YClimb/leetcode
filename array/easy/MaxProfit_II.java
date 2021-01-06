package array.easy;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author yclimb
 * @date 2020/12/9
 */
public class MaxProfit_II {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void test1() {
        int[] nums = new int[]{7,1,5,3,6,4};
        int i = maxProfit1(nums);
        //int i = maxProfit2(nums);
        System.out.println(i);
    }

    /**
     * 贪心算法
     */
    public static int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    /**
     * 双指针方法
     */
    public static int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int i = 0;
        int result = 0;
        for (int j = 1; j < prices.length; j++) {
            // i >= j，表示当前值没有可以买的
            if (prices[i] >= prices[j]) {
                i++;
                continue;
            }
            // 剩下的是 i < j
            // 如果是最后一次循环，直接计算价格并返回最终结果
            if (j + 1 == prices.length) {
                result += prices[j] - prices[i];
                break;
            }
            // 如果 i < j && j > j + 1，卖出，并计算交易后的价格
            if (prices[j] > prices[j + 1]) {
                result += prices[j] - prices[i];
                j = i = j + 1;
                continue;
            }
            // 如果 i < j && j < j + 1，则 j 继续往后查找最优解
            if (prices[j] < prices[j + 1]) {
                if (prices.length == j + 1) {
                    result += prices[j + 1] - prices[i];
                    break;
                }
            }
        }
        return result;
    }
}
