package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-
 * plane. The balloons are represented as a 2D integer array points where points[i]
 * = [xstart, xend] denotes a balloon whose horizontal diameter stretches between
 * xstart and xend. You do not know the exact y-coordinates of the balloons.
 * <p>
 * Arrows can be shot up directly vertically (in the positive y-direction) from
 * different points along the x-axis. A balloon with xstart and xend is burst by an
 * arrow shot at x if xstart <= x <= xend. There is no limit to the number of
 * arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any
 * balloons in its path.
 * <p>
 * Given the array points, return the minimum number of arrows that must be shot
 * to burst all balloons.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4
 * arrows.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= points.length <= 10⁵
 * points[i].length == 2
 * -2³¹ <= xstart < xend <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 贪心 数组 排序 👍 1025 👎 0
 */

public class Q452_MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        Solution solution = new Q452_MinimumNumberOfArrowsToBurstBalloons().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

            // for (int[] point : points) {
            //     System.out.println(Arrays.toString(point));
            // }

            int shots = 1, end = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= end) {
                    continue;
                }
                end = points[i][1];
                shots++;
            }
            return shots;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}