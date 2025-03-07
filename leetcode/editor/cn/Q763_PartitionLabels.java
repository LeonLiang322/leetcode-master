package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
You are given a string s. We want to partition the string into as many parts as 
possible so that each letter appears in at most one part. For example, the 
string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as [
"aba", "bcc"] or ["ab", "ab", "cc"] are invalid. 

 Note that the partition is done so that after concatenating all the parts in 
order, the resultant string should be s. 

 Return a list of integers representing the size of these parts. 

 
 Example 1: 

 
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits 
s into less parts.
 

 Example 2: 

 
Input: s = "eccbbbbdec"
Output: [10]
 

 
 Constraints: 

 
 1 <= s.length <= 500 
 s consists of lowercase English letters. 
 

 Related Topics 贪心 哈希表 双指针 字符串 👍 1252 👎 0

*/

public class Q763_PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new Q763_PartitionLabels().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0; int end = 0;
        for (int i = 0; i < n; i++) {
            // get the last index of the current character
            end = Math.max(end, last[s.charAt(i) - 'a']);
            // if the current index is the last index of the current character
            if (end == i) {
                partitions.add(end - start + 1);
                start = end + 1;
            }
        }

        return partitions;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}