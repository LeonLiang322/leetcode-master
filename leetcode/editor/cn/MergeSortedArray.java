package leetcode.editor.cn;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1 and
 * nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged, and the
 * last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to
 * ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10⁹ <= nums1[i], nums2[j] <= 10⁹
 * <p>
 * <p>
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 * <p>
 * Related Topics 数组 双指针 排序 👍 2437 👎 0
 */

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int mi = m - 1, ni = n - 1, i = m + n - 1;
            while (ni >= 0) {
                if (mi >= 0 && nums1[mi] > nums2[ni]) {
                    nums1[i--] = nums1[mi--];
                } else {
                    nums1[i--] = nums2[ni--];
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}