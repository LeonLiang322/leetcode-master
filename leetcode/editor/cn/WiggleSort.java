package leetcode.editor.cn;

import java.util.Arrays;

/**
 * Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2]
 * <= nums[3]....
 * <p>
 * You may assume the input array always has a valid answer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [3,5,2,1,6,4]
 * Output: [3,5,1,6,2,4]
 * Explanation: [1,6,2,5,3,4] is also accepted.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [6,6,5,6,3,8]
 * Output: [6,6,5,6,3,8]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 5 * 10⁴
 * 0 <= nums[i] <= 10⁴
 * It is guaranteed that there will be an answer for the given input nums.
 * <p>
 * <p>
 * <p>
 * Follow up: Could you solve the problem in O(n) time complexity?
 * <p>
 * Related Topics 贪心 数组 排序 👍 139 👎 0
 */

public class WiggleSort {
    public static void main(String[] args) {
        Solution solution = new WiggleSort().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // public void wiggleSort(int[] nums) {
        //     Arrays.sort(nums);
        //     int len = nums.length;
        //     int[] res = new int[len];
        //     int start = 0, end = len - 1;
        //     for (int i = 0; i < len; i++) {
        //         if (i % 2 == 1) {
        //             res[i] = nums[end];
        //             end--;
        //         } else {
        //             res[i] = nums[start];
        //             start++;
        //         }
        //     }
        //     System.arraycopy(res, 0, nums, 0, len);
        // }

        // public void wiggleSort(int[] nums) {
        //     Arrays.sort(nums);
        //     for (int i = 1; i < nums.length - 1; i += 2) {
        //         int next = i + 1;
        //         int temp = nums[i];
        //         nums[i] = nums[next];
        //         nums[next] = temp;
        //     }
        // }

        public void wiggleSort(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (((i % 2 == 0) && (nums[i] > nums[i + 1])) || ((i % 2 == 1) && (nums[i] < nums[i + 1]))) {
                    int next = i + 1;
                    int temp = nums[i];
                    nums[i] = nums[next];
                    nums[next] = temp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}