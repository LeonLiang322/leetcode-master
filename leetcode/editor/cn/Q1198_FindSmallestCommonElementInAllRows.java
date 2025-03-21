package leetcode.editor.cn;
/**
Given an m x n matrix mat where every row is sorted in strictly increasing 
order, return the smallest common element in all rows. 

 If there is no common element, return -1. 

 
 Example 1: 

 
Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5
 

 Example 2: 

 
Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
Output: 2
 

 
 Constraints: 

 
 m == mat.length 
 n == mat[i].length 
 1 <= m, n <= 500 
 1 <= mat[i][j] <= 10⁴ 
 mat[i] is sorted in strictly increasing order. 
 

 Related Topics 数组 哈希表 二分查找 计数 矩阵 👍 43 👎 0

*/

public class Q1198_FindSmallestCommonElementInAllRows {
    public static void main(String[] args) {
        Solution solution = new Q1198_FindSmallestCommonElementInAllRows().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestCommonElement(int[][] mat) {
        int m = mat[0].length, n = mat.length;
        int count[] = new int[10001];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (++count[mat[j][i]] == n) {
                    return mat[j][i];
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}