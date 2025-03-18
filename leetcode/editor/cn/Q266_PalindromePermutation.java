package leetcode.editor.cn;

import java.util.HashMap;

/**
Given a string s, return true if a permutation of the string could form a 
palindrome and false otherwise. 

 
 Example 1: 

 
Input: s = "code"
Output: false
 

 Example 2: 

 
Input: s = "aab"
Output: true
 

 Example 3: 

 
Input: s = "carerac"
Output: true
 

 
 Constraints: 

 
 1 <= s.length <= 5000 
 s consists of only lowercase English letters. 
 

 Related Topics 位运算 哈希表 字符串 👍 86 👎 0

*/

public class Q266_PalindromePermutation {
    public static void main(String[] args) {
        Solution solution = new Q266_PalindromePermutation().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (char k : map.keySet()) {
            count += map.get(k) % 2;
        }

        return count <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}