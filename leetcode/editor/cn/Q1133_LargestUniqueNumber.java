package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
Given an integer array nums, return the largest integer that only occurs once. 
If no integer occurs once, return -1. 

 
 Example 1: 

 
Input: nums = [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: The maximum integer in the array is 9 but it is repeated. The 
number 8 occurs only once, so it is the answer. 

 Example 2: 

 
Input: nums = [9,9,8,8]
Output: -1
Explanation: There is no number that occurs only once.
 

 
 Constraints: 

 
 1 <= nums.length <= 2000 
 0 <= nums[i] <= 1000 
 

 Related Topics 数组 哈希表 排序 👍 22 👎 0

*/

public class Q1133_LargestUniqueNumber {
    public static void main(String[] args) {
        Solution solution = new Q1133_LargestUniqueNumber().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && entry.getKey() > max) {
                max = entry.getKey();
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}