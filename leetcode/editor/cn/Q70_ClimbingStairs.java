package leetcode.editor.cn;
/**
You are climbing a staircase. It takes n steps to reach the top. 

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you 
climb to the top? 

 
 Example 1: 

 
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
 

 Example 2: 

 
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

 
 Constraints: 

 
 1 <= n <= 45 
 

 Related Topics 记忆化搜索 数学 动态规划 👍 3766 👎 0

*/

public class Q70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Q70_ClimbingStairs().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;704
            r = p + q;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}