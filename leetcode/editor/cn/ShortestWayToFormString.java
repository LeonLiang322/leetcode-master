package leetcode.editor.cn;

/**
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing the
 * relative positions of the remaining characters. (i.e., "ace" is a subsequence of
 * "abcde" while "aec" is not).
 * <p>
 * Given two strings source and target, return the minimum number of subsequences
 * of source such that their concatenation equals target. If the task is
 * impossible, return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: source = "abc", target = "abcbc"
 * Output: 2
 * Explanation: The target "abcbc" can be formed by "abc" and "bc", which are
 * subsequences of source "abc".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: source = "abc", target = "acdbc"
 * Output: -1
 * Explanation: The target string cannot be constructed from the subsequences of
 * source string due to the character "d" in target string.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: source = "xyz", target = "xzyxz"
 * Output: 3
 * Explanation: The target string can be constructed as follows "xz" + "y" + "xz".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= source.length, target.length <= 1000
 * source and target consist of lowercase English letters.
 * <p>
 * <p>
 * Related Topics 贪心 双指针 字符串 👍 128 👎 0
 */

public class ShortestWayToFormString {
    public static void main(String[] args) {
        Solution solution = new ShortestWayToFormString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestWay(String source, String target) {
            int ns = source.length(), nt = target.length();
            int pieceCount = 0;
            int is = 0, it = 0;
            boolean flag = false;
            while (it < nt) {
                if (is >= ns) {
                    if (!flag) return -1;
                    flag = false;
                    pieceCount++;
                    is = 0;
                }
                if (target.charAt(it) == source.charAt(is)) {
                    it++;
                    flag = true;
                }
                is++;
            }
            return ++pieceCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}