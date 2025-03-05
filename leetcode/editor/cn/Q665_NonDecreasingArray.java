package leetcode.editor.cn;
/**
Given an array nums with n integers, your task is to check if it could become 
non-decreasing by modifying at most one element. 

 We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every 
i (0-based) such that (0 <= i <= n - 2). 

 
 Example 1: 

 
Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 

 Example 2: 

 
Input: nums = [4,2,1]
Output: false
Explanation: You cannot get a non-decreasing array by modifying at most one 
element.
 

 
 Constraints: 

 
 n == nums.length 
 1 <= n <= 10⁴ 
 -10⁵ <= nums[i] <= 10⁵ 
 

 Related Topics 数组 👍 806 👎 0

*/

public class Q665_NonDecreasingArray {
    public static void main(String[] args) {
        Solution solution = new Q665_NonDecreasingArray().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) continue;
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}