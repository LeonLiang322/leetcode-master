package leetcode.editor.cn;

/**
 * Given a string s, return true if the s can be palindrome after deleting at most
 * one character from it.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "aba"
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "abc"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s consists of lowercase English letters.
 * <p>
 * <p>
 * Related Topics 贪心 双指针 字符串 👍 643 👎 0
 */

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean isPali(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }

        public boolean validPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPali(s, i + 1, j) || isPali(s, i, j - 1);
                }
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}