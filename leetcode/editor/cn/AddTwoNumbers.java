package leetcode.editor.cn;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a
 * single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading
 * zeros.
 * <p>
 * <p>
 * Related Topics 递归 链表 数学 👍 10525 👎 0
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}