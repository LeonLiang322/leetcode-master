package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * A confusing number is a number that when rotated 180 degrees becomes a
 * different number with each digit valid.
 * <p>
 * We can rotate digits of a number by 180 degrees to form new digits.
 * <p>
 * <p>
 * When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6
 * respectively.
 * When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.
 * <p>
 * <p>
 * Note that after rotating a number, we can ignore leading zeros.
 * <p>
 * <p>
 * For example, after rotating 8000, we have 0008 which is considered as just 8.
 * <p>
 * <p>
 * Given an integer n, return true if it is a confusing number, or false
 * otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 6
 * Output: true
 * Explanation: We get 9 after rotating 6, 9 is a valid number, and 9 != 6.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 89
 * Output: true
 * Explanation: We get 68 after rotating 89, 68 is a valid number and 68 != 89.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: n = 11
 * Output: false
 * Explanation: We get 11 after rotating 11, 11 is a valid number but the value
 * remains the same, thus 11 is not a confusing number
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= n <= 10⁹
 * <p>
 * <p>
 * Related Topics 数学 👍 33 👎 0
 */

public class ConfusingNumber {
    public static void main(String[] args) {
        Solution solution = new ConfusingNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // public boolean confusingNumber(int n) {
        //     HashMap<Character, Character> map = new HashMap<>();
        //     map.put('0', '0');
        //     map.put('1', '1');
        //     map.put('6', '9');
        //     map.put('8', '8');
        //     map.put('9', '6');
        //     String num = Integer.toString(n);
        //     char[] chars = num.toCharArray();
        //     StringBuilder res = new StringBuilder();
        //     for (char i : chars) {
        //         if (map.containsKey(i)) {
        //             res.insert(0, map.get(i));
        //         } else {
        //             return false;
        //         }
        //     }
        //     return !res.toString().equals(num);
        // }

        // public boolean confusingNumber(int n) {
        //     int res = 0;
        //     int origin = n;
        //     int mul = (int) Math.pow(10, Integer.toString(n).length() - 1);
        //     while (origin > 0) {
        //         int temp = origin % 10;
        //         if (temp == 0 || temp == 1 || temp == 8) {
        //             res += mul * temp;
        //         } else if (temp == 6 || temp == 9) {
        //             res += mul * (15 - temp);
        //         } else {
        //             return false;
        //         }
        //         origin = (origin - temp) / 10;
        //         mul /= 10;
        //     }
        //     return n != res;
        // }

        public boolean confusingNumber(int n) {
            int origin = n;
            StringBuilder sb = new StringBuilder("0");
            while (origin > 0) {
                int temp = origin % 10;
                if (temp == 0 || temp == 1 || temp == 8) {
                    sb.append(temp);
                } else if (temp == 6 || temp == 9) {
                    sb.append(15 - temp);
                } else {
                    return false;
                }
                origin = (origin - temp) / 10;
            }
            return n != Integer.parseInt(sb.toString());
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}