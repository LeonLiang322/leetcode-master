package leetcode.editor.cn;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the
 * array if you can flip at most one 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [1,0,1,1,0]
 * Output: 4
 * Explanation:
 * - If we flip the first zero, nums becomes [1,1,1,1,0] and we have 4 consecutive
 * ones.
 * - If we flip the second zero, nums becomes [1,0,1,1,1] and we have 3
 * consecutive ones.
 * The max number of consecutive ones is 4.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [1,0,1,1,0,1]
 * Output: 4
 * Explanation:
 * - If we flip the first zero, nums becomes [1,1,1,1,0,1] and we have 4
 * consecutive ones.
 * - If we flip the second zero, nums becomes [1,0,1,1,1,1] and we have 4
 * consecutive ones.
 * The max number of consecutive ones is 4.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] is either 0 or 1.
 * <p>
 * <p>
 * <p>
 * Follow up: What if the input numbers come in one by one as an infinite stream?
 * In other words, you can't store all numbers coming from the stream as it's too
 * large to hold in memory. Could you solve it efficiently?
 * <p>
 * Related Topics 数组 动态规划 滑动窗口 👍 150 👎 0
 */

public class Q487_MaxConsecutiveOnesIi {
    public static void main(String[] args) {
        Solution solution = new Q487_MaxConsecutiveOnesIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // public int findMaxConsecutiveOnes(int[] nums) {
        //     int n = nums.length;
        //     int left = 0, right = 0;
        //     int zero = 0;
        //     int ans = 0;
        //     while (right < n) {
        //         if (nums[right] == 0) {
        //             zero++;
        //         }
        //         while (zero > 1) {
        //             if (nums[left] == 0) {
        //                 zero--;
        //             }
        //             left++;
        //         }
        //         ans = Math.max(ans, right - left + 1);
        //         right++;
        //     }
        //     return ans;
        // }

        public int findMaxConsecutiveOnes(int[] nums) {
            int zero = -1, ans = 0, left = 0;
            for (int right = 0; right < nums.length; right++) {
                if (nums[right] == 0) {
                    left = zero + 1;
                    zero = right;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}