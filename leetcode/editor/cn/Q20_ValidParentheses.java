package leetcode.editor.cn;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid. 

 An input string is valid if: 

 
 Open brackets must be closed by the same type of brackets. 
 Open brackets must be closed in the correct order. 
 Every close bracket has a corresponding open bracket of the same type. 
 

 
 Example 1: 

 
 Input: s = "()" 
 

 Output: true 

 Example 2: 

 
 Input: s = "()[]{}" 
 

 Output: true 

 Example 3: 

 
 Input: s = "(]" 
 

 Output: false 

 Example 4: 

 
 Input: s = "([])" 
 

 Output: true 

 
 Constraints: 

 
 1 <= s.length <= 10⁴ 
 s consists of parentheses only '()[]{}'. 
 

 Related Topics 栈 字符串 👍 4671 👎 0

*/

public class Q20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q20_ValidParentheses().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.getFirst() != map.get(c)) {
                    return false;
                }
                stack.removeFirst();
            } else {
                stack.addFirst(c);
            }
        }

        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}