package leetcode.editor.cn;

/**
 * Given a string s and an integer k, return the number of substrings in s of
 * length k with no repeated characters.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "havefunonleetcode", k = 5
 * Output: 6
 * Explanation: There are 6 substrings they are: 'havef','avefu','vefun','efuno',
 * 'etcod','tcode'.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "home", k = 5
 * Output: 0
 * Explanation: Notice k can be larger than the length of s. In this case, it is
 * not possible to find any substring.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s consists of lowercase English letters.
 * 1 <= k <= 10⁴
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 57 👎 0
 */

public class FindKLengthSubstringsWithNoRepeatedCharacters {
    public static void main(String[] args) {
        Solution solution = new FindKLengthSubstringsWithNoRepeatedCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numKLenSubstrNoRepeats(String s, int k) {
            if (s.length() < k) return 0;

            int[] letters = new int[26];
            int left = 0, ans = 0;
            int count = 0;

            for (int right = 0; right < s.length(); right++) {
                if (++letters[s.charAt(right) - 'a'] == 1) {
                    count++;
                }
                if (right - left + 1 > k) {
                    if (--letters[s.charAt(left) - 'a'] == 0) {
                        count--;
                    }
                    left++;
                }
                if (right - left + 1 == k && count == k) {
                    ans++;
                }
            }

            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}