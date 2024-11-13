package leetcode.editor.cn;

import java.util.List;

/**
 * Given a string s and a string array dictionary, return the longest string in
 * the dictionary that can be formed by deleting some of the given string characters.
 * If there is more than one possible result, return the longest word with the
 * smallest lexicographical order. If there is no possible result, return the empty
 * string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s and dictionary[i] consist of lowercase English letters.
 * <p>
 * <p>
 * Related Topics 数组 双指针 字符串 排序 👍 370 👎 0
 */

public class Q524_LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new Q524_LongestWordInDictionaryThroughDeleting().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean isSubStr(String s, String dic) {
            int i = 0, j = 0;
            while (i < s.length() && j < dic.length()) {
                if (s.charAt(i) == dic.charAt(j)) j++;
                i++;
            }
            return j == dic.length();
        }

        public String findLongestWord(String s, List<String> dictionary) {
            String res = "";
            for (String dic : dictionary) {
                int l1 = res.length(), l2 = dic.length();
                if (l1 > l2 || (l1 == l2 && res.compareTo(dic) < 0)) continue;
                if (isSubStr(s, dic)) res = dic;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}