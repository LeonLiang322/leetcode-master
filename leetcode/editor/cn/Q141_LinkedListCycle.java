package leetcode.editor.cn;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle
 * in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer. Internally, pos is
 * used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 1st node (0-indexed).
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to
 * the 0th node.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of the nodes in the list is in the range [0, 10⁴].
 * -10⁵ <= Node.val <= 10⁵
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * <p>
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * <p>
 * Related Topics 哈希表 链表 双指针 👍 2155 👎 0
 */



public class Q141_LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new Q141_LinkedListCycle().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null && slow != null) {
                if (slow == fast) return true;
                fast = fast.next.next;
                slow = slow.next;
            }
            return false;
        }
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}