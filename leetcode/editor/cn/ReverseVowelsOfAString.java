package leetcode.editor.cn;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
 * and upper cases, more than once.
 * <p>
 * <p>
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 * <p>
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 3 * 10⁵
 * s consist of printable ASCII characters.
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 346 👎 0
 */

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean isVowel(char c) {
            return "aeiouAEIOU".indexOf(c) >= 0;
        }

        public String reverseVowels(String s) {
            int n = s.length();
            StringBuilder sb = new StringBuilder(s);
            int i = 0, j = n - 1;
            while (i < j) {
                while (i < n && !isVowel(sb.charAt(i))) {
                    i++;
                }
                while (j > 0 && !isVowel(sb.charAt(j))) {
                    j--;
                }
                if (i < j) {
                    char temp = sb.charAt(i);
                    sb.setCharAt(i, sb.charAt(j));
                    sb.setCharAt(j, temp);
                    i++;
                    j--;
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}