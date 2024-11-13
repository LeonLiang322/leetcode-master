package leetcode.editor.cn;

/**
 * Given a string s, return the length of the longest substring that contains at
 * most two distinct characters.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "eceba"
 * Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "ccaabbb"
 * Output: 5
 * Explanation: The substring is "aabbb" which its length is 5.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s consists of English letters.
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 229 👎 0
 */

public class Q159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new Q159_LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            int n = s.length();
            if (n < 3) {
                return n;
            }

            int left = 0;
            int right = 0;
            int maxLen = 2;
            int[] map = new int[128]; // 128 ASCII characters
            int count = 0;

            while (right < n) {
                // if the character is not in the map, increase the count
                if (map[s.charAt(right)] == 0) {
                    count++;
                }
                // increase the count of the character
                map[s.charAt(right)]++;
                right++;

                // if the count is greater than 2, move the left pointer to the right
                while (count > 2) {
                    map[s.charAt(left)]--;
                    if (map[s.charAt(left)] == 0) {
                        count--;
                    }
                    left++;
                }

                maxLen = Math.max(maxLen, right - left);
            }

            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}