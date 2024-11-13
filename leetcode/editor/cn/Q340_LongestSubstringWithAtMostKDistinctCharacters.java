package leetcode.editor.cn;


/**
 * Given a string s and an integer k, return the length of the longest substring
 * of s that contains at most k distinct characters.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 5 * 10⁴
 * 0 <= k <= 50
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 261 👎 0
 */

public class Q340_LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new Q340_LongestSubstringWithAtMostKDistinctCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            int n = s.length();
            if (n <= k) return s.length();

            int left = 0;
            int right = 0;
            int[] map = new int[128];
            int count = 0;
            int maxLen = 0;

            while (right < n) {
                if (map[s.charAt(right)] == 0) count++;
                map[s.charAt(right)]++;
                right++;
                while (count > k) {
                    map[s.charAt(left)]--;
                    if (map[s.charAt(left)] == 0) count--;
                    left++;
                }
                maxLen = Math.max(maxLen, right - left);

            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}