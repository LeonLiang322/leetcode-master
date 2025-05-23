package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
Given an integer array arr, count how many elements x there are, such that x + 1
 is also in arr. If there are duplicates in arr, count them separately. 

 
 Example 1: 

 
Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 

 Example 2: 

 
Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there is no 2, 4, 6, or 8 in arr.
 

 
 Constraints: 

 
 1 <= arr.length <= 1000 
 0 <= arr[i] <= 1000 
 

 Related Topics 数组 哈希表 👍 15 👎 0

*/

public class Q1426_CountingElements {
    public static void main(String[] args) {
        Solution solution = new Q1426_CountingElements().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int count = 0;
        for (int i : arr) {
            if (set.contains(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}