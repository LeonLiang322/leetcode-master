package leetcode.editor.cn;

/**
 * Given a non-negative integer c, decide whether there're two integers a and b
 * such that a² + b² = c.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: c = 3
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= c <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 数学 双指针 二分查找 👍 452 👎 0
 */

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            long i = 0, j = (long) Math.sqrt(c);
            while (i <= j) {
                long temp = i * i + j * j;
                if (temp == c) {
                    return true;
                } else if (temp > c) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}