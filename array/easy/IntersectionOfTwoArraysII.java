package array.easy;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 *
 * @author yclimb
 * @date 2020/12/14
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        test();
    }

    /**
     * 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     *
     * 示例 2:
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *  
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     *
     * 进阶：
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * 相关标签
     * 排序
     * 哈希表
     * 双指针
     * 二分查找
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2y0c2/
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void test() {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] nums = intersect(nums1, nums2);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 使用 hash 方式
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        // 将数组1存入map
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int num : nums1) {
            // 如果有相同元素，需要 value+1
            /*if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
                continue;
            }
            map.put(num, 1);*/
            // map.getOrDefault 表示存在则用 value，不存在则用 defaultValue=0
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 循环数组2，将值与map比较，如果存在则 list.add
        List<Integer> list = new ArrayList<>(nums2.length);
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                // 因为可能有多个相同元素，所以需要 value-1
                map.put(num, map.get(num) - 1);
            }
        }
        // list to []
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
