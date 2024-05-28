package leetcode.editor.cn;

/**
 * Given two strings s and t, return true if they are both one edit distance apart,
 * otherwise return false.
 * <p>
 * A string s is said to be one distance apart from a string t if you can:
 * <p>
 * <p>
 * Insert exactly one character into s to get t.
 * Delete exactly one character from s to get t.
 * Replace exactly one character of s with a different character to get t.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "", t = ""
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= s.length, t.length <= 10⁴
 * s and t consist of lowercase letters, uppercase letters, and digits.
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 140 👎 0
 */

public class OneEditDistance {
    public static void main(String[] args) {
        Solution solution = new OneEditDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            int ns = s.length();
            int nt = t.length();
            if (ns > nt) return isOneEditDistance(t, s); // 当s比t长时，调换位置重新判断
            if (nt - ns > 1) return false;
            for (int i = 0; i < ns; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (ns == nt) return s.substring(i + 1).equals(t.substring(i + 1));
                    else return s.substring(i).equals(t.substring(i + 1));
                }
            }
            return ns + 1 == nt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}