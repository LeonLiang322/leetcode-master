package leetcode.editor.cn;

import java.util.List;

/**
 * You are given m arrays, where each array is sorted in ascending order.
 * <p>
 * You can pick up two integers from two different arrays (each array picks one)
 * and calculate the distance. We define the distance between two integers a and b
 * to be their absolute difference |a - b|.
 * <p>
 * Return the maximum distance.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: arrays = [[1,2,3],[4,5],[1,2,3]]
 * Output: 4
 * Explanation: One way to reach the maximum distance 4 is to pick 1 in the first
 * or third array and pick 5 in the second array.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: arrays = [[1],[1]]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == arrays.length
 * 2 <= m <= 10⁵
 * 1 <= arrays[i].length <= 500
 * -10⁴ <= arrays[i][j] <= 10⁴
 * arrays[i] is sorted in ascending order.
 * There will be at most 10⁵ integers in all the arrays.
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 100 👎 0
 */

public class MaximumDistanceInArrays {
    public static void main(String[] args) {
        Solution solution = new MaximumDistanceInArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // time limit exceeded
        // public int maxDistance(List<List<Integer>> arrays) {
        //     int length = arrays.size();
        //     int min = 0;
        //     int max = 0;
        //     for (int i = 0; i < length; i++) {
        //         min = arrays.get(i).getFirst();
        //         for (int j = 0; j < length; j++) {
        //             if (i == j) {
        //                 continue;
        //             }
        //             max = Math.max(max, Math.abs(min - arrays.get(j).getLast()));
        //         }
        //     }
        //     return max;
        // }

        // time limit exceeded
        // public int maxDistance(List<List<Integer>> arrays) {
        //     int len = arrays.size();
        //     List<Integer> arr1, arr2;
        //     int result = 0;
        //     for (int i = 0; i < len - 1; i++) {
        //         for (int j = i + 1; j < len; j++) {
        //             arr1 = arrays.get(i);
        //             arr2 = arrays.get(j);
        //             result = Math.max(result, Math.abs(arr1.getFirst() - arr2.getLast()));
        //             result = Math.max(result, Math.abs(arr1.getLast() - arr2.getFirst()));
        //         }
        //     }
        //     return result;
        // }

        public int maxDistance(List<List<Integer>> arrays) {
            int len = arrays.size();
            int min_val = arrays.getFirst().getFirst();
            int max_val = arrays.getFirst().getLast();
            int res = 0;
            arrays.removeFirst();
            for (List<Integer> arr : arrays) {
                res = Math.max(res, Math.abs(min_val - arr.getLast()));
                res = Math.max(res, Math.abs(arr.getFirst() - max_val));
                // res = Math.max(res, Math.max(Math.abs(min_val - arr.getLast()), Math.abs(arr.getFirst() - max_val)));
                min_val = Math.min(min_val, arr.getFirst());
                max_val = Math.max(max_val, arr.getLast());
            }
            // for (int i = 1; i < len; i++) {
            //     res = Math.max(res, Math.abs(min_val - arrays.get(i).getLast()));
            //     res = Math.max(res, Math.abs(arrays.get(i).getFirst() - max_val));
            //     // res = Math.max(res, Math.max(Math.abs(arrays.get(i).getLast() - min_val), Math.abs(max_val - arrays.get(i).getFirst())));
            //     min_val = Math.min(min_val, arrays.get(i).getFirst());
            //     max_val = Math.max(max_val, arrays.get(i).getLast());
            // }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}