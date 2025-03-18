package leetcode.editor.cn;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Perform the following shift operations on a string: 

 
 Right shift: Replace every letter with the successive letter of the English 
alphabet, where 'z' is replaced by 'a'. For example, "abc" can be right-shifted to 
"bcd" or "xyz" can be right-shifted to "yza". 
 Left shift: Replace every letter with the preceding letter of the English 
alphabet, where 'a' is replaced by 'z'. For example, "bcd" can be left-shifted to 
"abc" or "yza" can be left-shifted to "xyz". 
 

 We can keep shifting the string in both directions to form an endless shifting 
sequence. 

 
 For example, shift "abc" to form the sequence: ... <-> "abc" <-> "bcd" <-> ... 
<-> "xyz" <-> "yza" <-> .... <-> "zab" <-> "abc" <-> ... 
 

 You are given an array of strings strings, group together all strings[i] that 
belong to the same shifting sequence. You may return the answer in any order. 

 
 Example 1: 

 
 Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"] 
 

 Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]] 

 Example 2: 

 
 Input: strings = ["a"] 
 

 Output: [["a"]] 

 
 Constraints: 

 
 1 <= strings.length <= 200 
 1 <= strings[i].length <= 50 
 strings[i] consists of lowercase English letters. 
 

 Related Topics 数组 哈希表 字符串 👍 140 👎 0

*/

public class Q249_GroupShiftedStrings {
    public static void main(String[] args) {
        Solution solution = new Q249_GroupShiftedStrings().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for(String s : strings) {
            List<Integer> diffList = new ArrayList<>();
            for (int i = 1; i < s.length(); i++) {
                int diff = s.charAt(i) - s.charAt(i - 1);
                if (diff < 0) diff += 26;
                diffList.add(diff);
            }
            List<String> wordList = map.getOrDefault(diffList, new ArrayList<String>());
            wordList.add(s);
            map.put(diffList, wordList);
        }

        // print the map
        // for (Map.Entry<List<Integer>, List<String>> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + " : " + entry.getValue());
        // }

        // List<List<String>> result = new ArrayList<>();
        // result.addAll(map.values());
        //
        // return result;

        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}