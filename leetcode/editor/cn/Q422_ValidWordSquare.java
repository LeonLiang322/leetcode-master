package leetcode.editor.cn;

import java.util.List;

/**
Given an array of strings words, return true if it forms a valid word square. 

 A sequence of strings forms a valid word square if the kᵗʰ row and column read 
the same string, where 0 <= k < max(numRows, numColumns). 

 
 Example 1: 
 
 
Input: words = ["abcd","bnrt","crmy","dtye"]
Output: true
Explanation:
The 1ˢᵗ row and 1ˢᵗ column both read "abcd".
The 2ⁿᵈ row and 2ⁿᵈ column both read "bnrt".
The 3ʳᵈ row and 3ʳᵈ column both read "crmy".
The 4ᵗʰ row and 4ᵗʰ column both read "dtye".
Therefore, it is a valid word square.
 

 Example 2: 
 
 
Input: words = ["abcd","bnrt","crm","dt"]
Output: true
Explanation:
The 1ˢᵗ row and 1ˢᵗ column both read "abcd".
The 2ⁿᵈ row and 2ⁿᵈ column both read "bnrt".
The 3ʳᵈ row and 3ʳᵈ column both read "crm".
The 4ᵗʰ row and 4ᵗʰ column both read "dt".
Therefore, it is a valid word square.
 

 Example 3: 
 
 
Input: words = ["ball","area","read","lady"]
Output: false
Explanation:
The 3ʳᵈ row reads "read" while the 3ʳᵈ column reads "lead".
Therefore, it is NOT a valid word square.
 

 
 Constraints: 

 
 1 <= words.length <= 500 
 1 <= words[i].length <= 500 
 words[i] consists of only lowercase English letters. 
 

 Related Topics 数组 矩阵 👍 58 👎 0

*/

public class Q422_ValidWordSquare {
    public static void main(String[] args) {
        Solution solution = new Q422_ValidWordSquare().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for (int i = 0; i < n; i++) {
            if (words.get(i).length() > n) return false;
            for (int j = i + 1; j < n; j++) {
                // System.out.println(words.get(i).charAt(j) + "->" + words.get(j).charAt(i));
                char c1 = words.get(i).length() > j ? words.get(i).charAt(j) : ' ';
                char c2 = words.get(j).length() > i ? words.get(j).charAt(i) : ' ';
                // System.out.println(c1 + "->" + c2);
                if (c1 != c2) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}