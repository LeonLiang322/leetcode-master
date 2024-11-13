# 尊享面试100题

## 624. [数组列表中的最大距离](./leetcode/editor/cn/MaximumDistanceInArrays.java)

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

## 280. [摆动排序](./leetcode/editor/cn/WiggleSort.java)

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

## 1056. [易混淆数](./leetcode/editor/cn/ConfusingNumber.java)

由于倒转后的值是顺序变为逆序的，所以用纯数学方法储存结果需要知道数值的位数，并不方便。所以在此处使用StringBuilder创建字符串来储存结果。

创建数值的副本，每次通过取余来获得最后一位数，上下倒转后append到StringBuilder中，并将副本减去该值。例如：

number=8196, res="0"

第一次处理后：number=819, res="06"

第二次处理后：number=81, res="061"

以此类推，并最终使用`Integer.parseInt`转化为整数，开头的0会自动去除

## 1427. [字符串的左右移](./leetcode/editor/cn/PerformStringShifts.java)

首先以整数形式计算最终的移动方向和步数，存于`finalShift`中

`finalShift`取余以省略超出字符串长度的移动步数

当`finalShift`为负，即向左移动时，加上字符串长度即可转换为向右移动的步数

以`finalShift`为切点，以后半部分+前半部分的形式返回结果

## 161. [相隔为1的编辑距离](./leetcode/editor/cn/OneEditDistance.java)

当两个字符串长度相差大于1时，直接返回false

当两个字符串长度相差为1时，遍历较长的字符串，若遇到不同字符，则比较两个字符串的剩余部分是否相同

当两个字符串长度相同时，遍历字符串，若遇到不同字符，则比较两个字符串的剩余部分是否相同

为避免代码额外判断字符串更长，我们只需默认第一个字符串更长，若不是则调换两个字符串的位置即可重新调用一次函数即可

## 186. [反转字符串中的单词II](./leetcode/editor/cn/ReverseWordsInAStringIi.java)

首先将整个字符串反转，然后遍历字符串

记录单词的起始位置，当遇到空格则将start到当前位置的单词反转

由于最后一个单词后并没有空格，所以最后手动将该单词反转

## 1055. [形成字符串的最短路径](./leetcode/editor/cn/ShortestWayToFormString.java)

使用双指针的思路，遍历`source`字符串，当`source`的字符与`target`的字符相同时，两个指针同时向后移动

当`source`的字符与`target`的字符不同时，只有`source`的指针向后移动

当`source`的指针到达末尾时，如果`target`的当前字符未能在`source`中找到，则返回-1

否则，`source`的指针回到开头，计数器+1

## 159. [至多包含两个不同字符的最长子串](./leetcode/editor/cn/LongestSubstringWithAtMostTwoDistinctCharacters.java)

当字符串长度小于等于2时，直接返回字符串长度

使用滑动窗口的思路，定义窗口左右指针，首先移动右指针遍历字符串

当当前字符没有在窗口中时，将其出现次数记录在map中，并更新用来统计当前已出现的字符数`count`

当当前字符已在窗口中时，更新map中该字符的出现次数

接下来进行while判断： 当`count`大于2时，移动左指针，在map中减去左指针对应的字符的出现次数。当该字符的出现次数为0时，`count`
减1。

当`count`减到2时，更新最大长度

## 340. [至多包含 K 个不同字符的最长子串](./leetcode/editor/cn/LongestSubstringWithAtMostKDistinctCharacters.java)

与上一题类似，只是将`count`的判断条件改为`count > k`即可

## 487. [最大连续1的个数 II](./leetcode/editor/cn/MaxConsecutiveOnesIi.java)

**
该题仍然可以使用上两题的滑动窗口思路，但是由于只能翻转一次0，所以只需要在碰到第二个0时，将左指针移动到第一个0的下一位即可
**

使用滑动窗口的思路，定义窗口左右指针，首先移动右指针遍历数组

当当前字符为0时，将左指针移动到前一个0的位置的下一位，并将当前0的位置记录到`zero`中

每次更新最大长度

## 1100. [长度为 K 的无重复字符子串](./leetcode/editor/cn/Q1100_FindKLengthSubstringsWithNoRepeatedCharacters.java)

与159类似，使用滑动窗口的思路

当滑窗长度大于`k`时，移动左指针并在`map`中减去左指针对应的字符的出现次数。当该字符的出现次数为0时，`count`减1

当滑窗长度等于`k`时，如果当前字符也刚好五种，则计数器+1

## 760. [找出变位映射](./leetcode/editor/cn/FindAnagramMappings.java)

使用双循环的方法就不赘述了，这里使用标准思路hashmap来存储`num2`数组的值和对应的下标

遍历`num1`数组，将`num1`数组的值和对应的下标存储在map中，然后遍历`num2`数组，将`num2`数组的值在map中查找对应的下标


