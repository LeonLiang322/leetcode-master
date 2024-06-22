package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the
 * intervals non-overlapping.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-
 * overlapping.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-
 * overlapping.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= intervals.length <= 10⁵
 * intervals[i].length == 2
 * -5 * 10⁴ <= starti < endi <= 5 * 10⁴
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 排序 👍 1134 👎 0
 */

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;
            // Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // return (o1[1] < o2[1]) ? -1 : (o1[1] == o2[1]) ? 0 : 1;
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            int available = 1;
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < end) continue;
                available++;
                end = intervals[i][1];
            }
            return intervals.length - available;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}