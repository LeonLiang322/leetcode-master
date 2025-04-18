package leetcode.editor.cn;
/**
Given an array of integers nums which is sorted in ascending order, and an 
integer target, write a function to search target in nums. If target exists, then 
return its index. Otherwise, return -1. 

 You must write an algorithm with O(log n) runtime complexity. 

 
 Example 1: 

 
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
 

 Example 2: 

 
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁴ 
 -10⁴ < nums[i], target < 10⁴ 
 All the integers in nums are unique. 
 nums is sorted in ascending order. 
 

 Related Topics 数组 二分查找 👍 1714 👎 0

*/

public class Q704_BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Q704_BinarySearch().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}