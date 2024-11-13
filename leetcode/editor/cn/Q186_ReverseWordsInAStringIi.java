package leetcode.editor.cn;

/**
 * Given a character array s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by a single space.
 * <p>
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * <p>
 * Example 2:
 * Input: s = ["a"]
 * Output: ["a"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
 * There is at least one word in s.
 * s does not contain leading or trailing spaces.
 * All the words in s are guaranteed to be separated by a single space.
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 125 👎 0
 */

public class Q186_ReverseWordsInAStringIi {
    public static void main(String[] args) {
        Solution solution = new Q186_ReverseWordsInAStringIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseWords(char[] s) {
            reverse(s, 0, s.length - 1);

            int start = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == ' ') {
                    reverse(s, start, i - 1);
                    start = i + 1;
                }
            }

            reverse(s, start, s.length - 1);
        }

        public void reverse(char[] s, int start, int end) {
            while (start < end) {
                char temp = s[start];
                s[start] = s[end];
                s[end] = temp;
                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}