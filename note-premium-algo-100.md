# 尊享面试100题

## 624. [数组列表中的最大距离](https://leetcode.cn/problems/maximum-distance-in-arrays/)

Code: [624. 数组列表中的最大距离](./leetcode/editor/cn/Q624_MaximumDistanceInArrays.java)

### 暴力解法

由于所有数组内的数是已经经过排列的了，所以我们只需要比较两个相邻数组的第一位和最后一位就行（两次）。

时间复杂度n<sup>2</sup>

### 单次扫描（贪心）

维护整体的min_val和max_val，将它们初始化为第一个数组的极值。创建res储存结果并初始化为0。

遍历一遍从第二个数组开始，计算该数组的最大值与min_val的差值、该数组的最小值与max_val的差值，取res和这些结果的最大值，并更新min_val和max_val。

总而言之，min_val和max_val都是对于所有数组来说的最大最小值，检查每个数组时去与当前的最大最小来比较就可以得出结果。

#### QA

Q: 如果最大和最小同时在一个数组中会发生什么？

A: max_val和min_val在使用时是处理之前的数组时记录的，并不会影响结果

## 280. [摆动排序](https://leetcode.cn/problems/wiggle-sort/)

Code: [280. 摆动排序](./leetcode/editor/cn/Q280_WiggleSort.java)

### 暴力解法

将数组排序后，每两位之间互换即可

### 贪心算法

假设有数组[0],[1],[2],[3],[4]...

遍历数组，若[0]>[1]，则将[0]和[1]互换（相反则满足条件，不动）

此时[0]<[1]，继续下一位[2]

若[1]<[2]，互换[1]和[2]（因为[0]<[1]，所以在互换后仍满足[0]<[2])

此时[0]<=[2]>=[1]，继续下一位[3]

若[1]>[3]，互换[1]和[3]（因为[2]>[1]，所以在互换后仍满足[2]>[3])

此时[0]<[2]>[3]<[1]

以此类推...

总结规律，则当i为偶数位时，判断[i+1]是否大于[i]，是则互换

则当i为奇数位时，判断[i+1]是否小于[i]，是则互换

## 1056. [易混淆数](https://leetcode.cn/problems/confusing-number/)

Code: [1056. 易混淆数](./leetcode/editor/cn/Q1056_ConfusingNumber.java)

由于倒转后的值是顺序变为逆序的，所以用纯数学方法储存结果需要知道数值的位数，并不方便。所以在此处使用StringBuilder创建字符串来储存结果。

创建数值的副本，每次通过取余来获得最后一位数，上下倒转后append到StringBuilder中，并将副本减去该值。例如：

number=8196, res="0"

第一次处理后：number=819, res="06"

第二次处理后：number=81, res="061"

以此类推，并最终使用`Integer.parseInt`转化为整数，开头的0会自动去除

## 1427. [字符串的左右移](https://leetcode.cn/problems/perform-string-shifts/)

Code: [1427. 字符串的左右移](./leetcode/editor/cn/Q1427_PerformStringShifts.java)

首先以整数形式计算最终的移动方向和步数，存于`finalShift`中

`finalShift`取余以省略超出字符串长度的移动步数

当`finalShift`为负，即向左移动时，加上字符串长度即可转换为向右移动的步数

以`finalShift`为切点，以后半部分+前半部分的形式返回结果

## 161. [相隔为1的编辑距离](https://leetcode.cn/problems/one-edit-distance/)

Code: [161. 相隔为1的编辑距离](./leetcode/editor/cn/Q161_OneEditDistance.java)

当两个字符串长度相差大于1时，直接返回false

当两个字符串长度相差为1时，遍历较长的字符串，若遇到不同字符，则比较两个字符串的剩余部分是否相同

当两个字符串长度相同时，遍历字符串，若遇到不同字符，则比较两个字符串的剩余部分是否相同

为避免代码额外判断字符串更长，我们只需默认第一个字符串更长，若不是则调换两个字符串的位置即可重新调用一次函数即可

## 186. [反转字符串中的单词II](https://leetcode.cn/problems/reverse-words-in-a-string-ii/)

Code: [186. 反转字符串中的单词 II](./leetcode/editor/cn/Q186_ReverseWordsInAStringIi.java)

首先将整个字符串反转，然后遍历字符串

记录单词的起始位置，当遇到空格则将start到当前位置的单词反转

由于最后一个单词后并没有空格，所以最后手动将该单词反转

## 1055. [形成字符串的最短路径](https://leetcode.cn/problems/shortest-way-to-form-string/)

Code: [1055. 形成字符串的最短路径](./leetcode/editor/cn/Q1055_ShortestWayToFormString.java)

使用双指针的思路，遍历`source`字符串，当`source`的字符与`target`的字符相同时，两个指针同时向后移动

当`source`的字符与`target`的字符不同时，只有`source`的指针向后移动

当`source`的指针到达末尾时，如果`target`的当前字符未能在`source`中找到，则返回-1

否则，`source`的指针回到开头，计数器+1

## 159. [至多包含两个不同字符的最长子串](https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/)

Code: [159. 至多包含两个不同字符的最长子串](./leetcode/editor/cn/Q159_LongestSubstringWithAtMostTwoDistinctCharacters.java)

当字符串长度小于等于2时，直接返回字符串长度

使用滑动窗口的思路，定义窗口左右指针，首先移动右指针遍历字符串

当当前字符没有在窗口中时，将其出现次数记录在map中，并更新用来统计当前已出现的字符数`count`

当当前字符已在窗口中时，更新map中该字符的出现次数

接下来进行while判断： 当`count`大于2时，移动左指针，在map中减去左指针对应的字符的出现次数。当该字符的出现次数为0时，`count`
减1。

当`count`减到2时，更新最大长度

## 340. [至多包含 K 个不同字符的最长子串](https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/)

Code: [340. 至多包含 K 个不同字符的最长子串](./leetcode/editor/cn/Q340_LongestSubstringWithAtMostKDistinctCharacters.java)

与上一题类似，只是将`count`的判断条件改为`count > k`即可

## 487. [最大连续1的个数 II](https://leetcode.cn/problems/max-consecutive-ones-ii/)

Code: [487. 最大连续1的个数 II](./leetcode/editor/cn/Q487_MaxConsecutiveOnesIi.java)

**
该题仍然可以使用上两题的滑动窗口思路，但是由于只能翻转一次0，所以只需要在碰到第二个0时，将左指针移动到第一个0的下一位即可
**

使用滑动窗口的思路，定义窗口左右指针，首先移动右指针遍历数组

当当前字符为0时，将左指针移动到前一个0的位置的下一位，并将当前0的位置记录到`zero`中

每次更新最大长度

## 1100. [长度为 K 的无重复字符子串](https://leetcode.cn/problems/find-k-length-substrings-with-no-repeated-characters/)

Code: [1100. 长度为 K 的无重复字符子串](./leetcode/editor/cn/Q1100_FindKLengthSubstringsWithNoRepeatedCharacters.java)

与159类似，使用滑动窗口的思路

当滑窗长度大于`k`时，移动左指针并在`map`中减去左指针对应的字符的出现次数。当该字符的出现次数为0时，`count`减1

当滑窗长度等于`k`时，如果当前字符也刚好五种，则计数器+1

## 760. [找出变位映射](https://leetcode.cn/problems/find-anagram-mappings/)

Code: [760. 找出变位映射](./leetcode/editor/cn/Q760_FindAnagramMappings.java)

使用双循环的方法就不赘述了，这里使用标准思路hashmap来存储`num2`数组的值和对应的下标

遍历`num1`数组，将`num1`数组的值和对应的下标存储在map中，然后遍历`num2`数组，将`num2`数组的值在map中查找对应的下标

## 266. [回文排列](https://leetcode.cn/problems/palindrome-permutation/)

Code: [266. 回文排列](./leetcode/editor/cn/Q266_PalindromePermutation.java)

使用hashmap来存储字符和对应的出现次数，计算出现次数为奇数的字符个数，最终结果小于等于1即可

## 734. [句子相似性](https://leetcode.cn/problems/sentence-similarity/)

Code: [734. 句子相似性](./leetcode/editor/cn/Q734_SentenceSimilarity.java)

首先判断两个句子的长度是否相同，若不同则直接返回false

使用Set来储存拼接起来的单词对，然后遍历句子中的每个单词

相似的条件：
1. 两个单词长度相同
2. 第一个单词拼接第二个单词在Set中存在
3. 第二个单词拼接第一个单词在Set中存在

## 1165. [单行键盘](https://leetcode.cn/problems/single-row-keyboard/)

Code: [1165. 单行键盘](./leetcode/editor/cn/Q1165_SingleRowKeyboard.java)

创建一个26位的数组来储存每个字母在键盘上的位置索引

创建`prev`变量来储存上一个字母的位置索引

遍历字符串中的每个字母，将当前字母的位置索引与上一个字母的位置索引差值的绝对值相加，更新`prev`为当前字母的位置索引

## 249. [移位字符串分组](https://leetcode.cn/problems/group-shifted-strings/)

Code: [249. 移位字符串分组](./leetcode/editor/cn/Q249_GroupShiftedStrings.java)

整体思路就是使用hashmap来存储每个字符串中每个字母之间的差值和对应的字符串列表，如
`"abc"`和`"bcd"`的差值是`1,1`，所以它们会被放在同一个列表中，具体形如`1,1 -> "abc", "bcd"`

具体步骤：

1. 首先为每个字符串创建一个列表记录差值。此时注意当差值为负数时，需要加上26来匹配跨越字母表的情况，如
`"az"`和`"ba"`的差值分别为`25`和`-1`，但实际上它们的差值是相同的为`25`
2. 获取当前map的值，若map中没有该差值，则将其添加到map中，并将当前字符串添加到对应的列表中，若有则直接添加到对应的列表中
3. 最后将map中的所有值添加到结果列表中并返回

## 1133. [最大唯一数](https://leetcode.cn/problems/largest-unique-number/)

Code: [1133. 最大唯一数](./leetcode/editor/cn/Q1133_LargestUniqueNumber.java)

使用hashmap来存储每个数字的出现次数，遍历map中的每个数字，若该数字的出现次数为1，则更新最大值

## 1426. [数元素](https://leetcode.cn/problems/counting-elements/)

Code: [1426. 数元素](./leetcode/editor/cn/Q1426_CountingElements.java)

将数组使用hashset来存储，遍历数组中的每个数字，判断该数字+1是否在hashset中存在，若存在则计数器+1

## 1198. [找到所有行中最小公共元素](https://leetcode.cn/problems/find-smallest-common-element-in-all-rows/)

Code: [1198. 找到所有行中最小公共元素](./leetcode/editor/cn/Q1198_FindSmallestCommonElementInAllRows.java)

当某个数字在所有行中出现的次数等于行数时，返回该数字即可

由于题目给出限制数字大小在1-10000之间，所以创建一个10001大小的数组来储存每个数字出现的次数

同时每行的数字时严格递增的，所以按照列的顺序进行计数可以更快找到

本题还有二分法优化方案，具体参考题解

## 422. [有效的单词方块](https://leetcode.cn/problems/valid-word-square/)

Code: [422. 有效的单词方块](./leetcode/editor/cn/Q422_ValidWordSquare.java)

示例
```
abcd
bnrt
crmy
dtye
```

可以看出，第一行的第一个字母和第二行的第一个字母相同，第二行的第二个字母和第三行的第二个字母相同，以此类推

所以只需要判断每一行的第i个字母是否等于第i行的第j个字母即可

需要注意的是，当单词长度超过了行数时，直接返回false，如`abc`和`b`
