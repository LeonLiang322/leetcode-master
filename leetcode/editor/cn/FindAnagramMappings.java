package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two integer arrays nums1 and nums2 where nums2 is an anagram of
 * nums1. Both arrays may contain duplicates.
 * <p>
 * Return an index mapping array mapping from nums1 to nums2 where mapping[i] = j
 * means the iᵗʰ element in nums1 appears in nums2 at index j. If there are
 * multiple answers, return any of them.
 * <p>
 * An array a is an anagram of an array b means b is made by randomizing the
 * order of the elements in a.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums1 = [12,28,46,32,50], nums2 = [50,12,32,46,28]
 * Output: [1,4,3,2,0]
 * Explanation: As mapping[0] = 1 because the 0ᵗʰ element of nums1 appears at nums2
 * [1], and mapping[1] = 4 because the 1ˢᵗ element of nums1 appears at nums2[4],
 * and so on.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums1 = [84,46], nums2 = [84,46]
 * Output: [0,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums1.length <= 100
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10⁵
 * nums2 is an anagram of nums1.
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 50 👎 0
 */

public class FindAnagramMappings {
    public static void main(String[] args) {
        Solution solution = new FindAnagramMappings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // public int[] anagramMappings(int[] nums1, int[] nums2) {
        //     int[] ans = new int[nums1.length];
        //     for (int i = 0; i < nums1.length; i++) {
        //         for (int j = 0; j < nums2.length; j++) {
        //             if (nums2[j] == nums1[i]) ans[i] = j;
        //         }
        //     }
        //     return ans;
        //
        // }

        // use hashmap
        public int[] anagramMappings(int[] nums1, int[] nums2) {
            int[] ans = new int[nums1.length];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                map.put(nums2[i], i);
            }
            for (int i = 0; i < nums1.length; i++) {
                ans[i] = map.get(nums1[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}