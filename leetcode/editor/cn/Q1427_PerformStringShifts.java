package leetcode.editor.cn;

/**
 * You are given a string s containing lowercase English letters, and a matrix
 * shift, where shift[i] = [directioni, amounti]:
 * <p>
 * <p>
 * directioni can be 0 (for left shift) or 1 (for right shift).
 * amounti is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the
 * end.
 * Similarly, a right shift by 1 means remove the last character of s and add it
 * to the beginning.
 * <p>
 * <p>
 * Return the final string after all operations.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation: 
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation: 
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * directioni is either 0 or 1.
 * 0 <= amounti <= 100
 * <p>
 * <p>
 * Related Topics 数组 数学 字符串 👍 16 👎 0
 */

public class Q1427_PerformStringShifts {
    public static void main(String[] args) {
        Solution solution = new Q1427_PerformStringShifts().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String stringShift(String s, int[][] shift) {
            int finalShift = 0;
            for (int[] action : shift) {
                if (action[0] == 1)
                    finalShift += action[1];
                else
                    finalShift -= action[1];
            }
            finalShift %= s.length();
            if (finalShift == 0) return s;
            if (finalShift < 0) finalShift += s.length();
            return s.substring(s.length() - finalShift) + s.substring(0, s.length() - finalShift);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}