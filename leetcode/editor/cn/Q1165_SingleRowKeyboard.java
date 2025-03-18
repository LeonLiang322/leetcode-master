package leetcode.editor.cn;
/**
There is a special keyboard with all keys in a single row. 

 Given a string keyboard of length 26 indicating the layout of the keyboard (
indexed from 0 to 25). Initially, your finger is at index 0. To type a character, 
you have to move your finger to the index of the desired character. The time 
taken to move your finger from index i to index j is |i - j|. 

 You want to type a string word. Write a function to calculate how much time it 
takes to type it with one finger. 

 
 Example 1: 

 
Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
Output: 4
Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' 
then to 0 again to write 'a'.
Total time = 2 + 1 + 1 = 4. 
 

 Example 2: 

 
Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
Output: 73
 

 
 Constraints: 

 
 keyboard.length == 26 
 keyboard contains each English lowercase letter exactly once in some order. 
 1 <= word.length <= 10⁴ 
 word[i] is an English lowercase letter. 
 

 Related Topics 哈希表 字符串 👍 37 👎 0

*/

public class Q1165_SingleRowKeyboard {
    public static void main(String[] args) {
        Solution solution = new Q1165_SingleRowKeyboard().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculateTime(String keyboard, String word) {
        // 确定了键盘中每个键所对应的索引
        int[] keyIndices = new int[26];

        for (int i = 0; i < keyboard.length(); i++) {
            keyIndices[keyboard.charAt(i) - 'a'] = i;
        }

        int sum = 0, prev = 0;
        for (char c : word.toCharArray()) {
            sum += Math.abs(keyIndices[c - 'a'] - prev);
            prev = keyIndices[c - 'a'];
        }

        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}