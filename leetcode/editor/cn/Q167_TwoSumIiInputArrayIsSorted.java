package leetcode.editor.cn;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-
 * decreasing order, find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 <
 * index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We
 * return [1, 2].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We
 * return [1, 3].
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We
 * return [1, 2].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 2 <= numbers.length <= 3 * 10⁴
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 * <p>
 * <p>
 * Related Topics 数组 双指针 二分查找 👍 1208 👎 0
 */

public class Q167_TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new Q167_TwoSumIiInputArrayIsSorted().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                int temp = numbers[i] + numbers[j];
                if (temp == target) {
                    return new int[]{i + 1, j + 1};
                } else if (temp > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}