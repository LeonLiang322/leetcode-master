# CS-Notes面试笔记力扣经典题

## 1. [两数之和](https://leetcode.cn/problems/two-sum/)

Code: [1. 两数之和](./leetcode/editor/cn/Q1_TwoSum.java)

使用哈希表的思路，遍历数组，将数组的值和索引存入哈希表，然后再次遍历数组，查找`target - nums[i]`是否在哈希表中

## 167. [两数之和 II - 输入有序数组](https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/)

Code: [167. 两数之和 II - 输入有序数组](./leetcode/editor/cn/Q167_TwoSumIiInputArrayIsSorted.java)

使用双指针的思路，定义左指针指向0，右指针指向`numbers.length - 1`

当两个指针指向的数之和大于`target`时，右指针向左移动，否则左指针向右移动

## 633. [平方数之和](https://leetcode.cn/problems/sum-of-square-numbers/)

Code: [633. 平方数之和](./leetcode/editor/cn/Q633_SumOfSquareNumbers.java)

使用双指针的思路，定义左指针指向0，右指针指向`sqrt(c)`

当两个指针指向的数分别的平方之和大于`c`时，右指针向左移动，否则左指针向右移动

### 为什么不会错过正确答案？

举个例子，当`c = 18`时，`sqrt(5) = 2`，初始化`i = 0`，`j = 4`，那么看如下矩阵：

```
0  1  4  9  16
1  2  5  10 17
4  5  8  13 20
9  10 13 18 25
16 17 20 25 32
```

其中，x轴是`j`的值，y轴是`i`的值，矩阵中的值是`i^2 + j^2`的值

查找的过程具有如下性质

- 初始化时的值必在矩阵的右上角
- 每次比较平方和与`c`的大小时，可以排除矩阵的一行或一列

由于以上性质，当前格子的上方和右边的所有元素都一定是已经被排除的，所以当前格子在搜索过程中只有两种行为：

1. 小于`c`：左边的所有元素都小于当前元素，只能下移，即`i++`。此时排除的是黄色格子以及左边同行的元素，都小于`c`，所以不会错过正确答案。
2. 大于`c`：下方的所有元素都大于当前元素，只能左移，即`j--`。此时排除的是黄色格子以及下方同列的元素，都大于`c`，所以不会错过正确答案。

### 为什么使用`long`？

因为存在`0 <= c <= 2^31 - 1`

## 345. [反转字符串中的元音字母](https://leetcode.cn/problems/reverse-vowels-of-a-string/)

Code: [345. 反转字符串中的元音字母](./leetcode/editor/cn/Q345_ReverseVowelsOfAString.java)

使用双指针的思路，定义左指针指向0，右指针指向`n - 1`

当左指针指向的字符不是元音字母时，左指针向右移动

当右指针指向的字符不是元音字母时，右指针向左移动

当左指针指向的字符是元音字母且右指针指向的字符是元音字母时，交换两个字符，左指针向右移动，右指针向左移动

`String`类型是不可变的，所以可以使用`StringBuilder`或者`toCharArray()`的方式来修改字符串

## 680. [验证回文字符串 Ⅱ](https://leetcode.cn/problems/valid-palindrome-ii/)

Code: [680. 验证回文字符串 Ⅱ](./leetcode/editor/cn/Q680_ValidPalindromeIi.java)

使用双指针的思路，定义左指针指向0，右指针指向`n - 1`

由于只能删除一个字符，所以只要有一个分支是回文串，那么整个字符串就是回文串，所以当左指针指向的字符不等于右指针指向的字符时，可以尝试进行删除操作：

- 当删除左边的字符时，左指针向右移动，右指针不动，然后继续判断完剩余的字符串是否是回文串
- 当删除右边的字符时，右指针向左移动，左指针不动，然后继续判断完剩余的字符串是否是回文串

## 88. [合并两个有序数组](https://leetcode.cn/problems/merge-sorted-array/)

Code: [88. 合并两个有序数组](./leetcode/editor/cn/Q88_MergeSortedArray.java)

使用双指针的思路，定义`mi`指向`nums1`的数据尾部，`ni`指向`nums2`数据尾部，`i`指向`nums1`的数组尾部

从后往前遍历，当`mi >= 0`且`ni >= 0`时，比较`nums1[mi]`和`nums2[ni]`的大小，将较大的值放到`nums1[i]`，然后`mi--`或`ni--`，
`i--`

### 为什么while中的条件只需要`ni >= 0`？

因为当`ni < 0`时，说明`nums2`中的元素已经全部放到`nums1`中了，且此时`nums1`中的元素已经是有序的，不需要再进行操作

## 141. [环形链表](https://leetcode.cn/problems/linked-list-cycle/)

Code: [141. 环形链表](./leetcode/editor/cn/Q141_LinkedListCycle.java)

使用快慢指针的思路，定义快指针`fast`指向`head.next`，慢指针`slow`指向`head`

`fast`每次移动两步，`slow`每次移动一步，当`fast`和`slow`相遇时，说明链表中存在环

## 524. [通过删除字母匹配到字典里最长单词](https://leetcode.cn/problems/longest-word-in-dictionary-through-deleting/)

Code: [524. 通过删除字母匹配到字典里最长单词](./leetcode/editor/cn/Q524_LongestWordInDictionaryThroughDeleting.java)

创建`res`储存结果，遍历字典中的单词，对每个单词`dic`进行检查：

- 如果`dic`长度小于`res`的长度，则直接跳过
- 如果`dic`长度等于`res`的长度，且`dic`字典序小于`res`，也直接跳过。此处由于`res`是完整的单词，所以直接与`dic`比较即可

当不跳过时，检查`dic`是否是`s`的子序列，如果是，则更新`res`

检查的思路使用双指针，定义`i`指向`s`的头部，`j`指向`dic`的头部，循环比较`s[i]`和`dic[j]`是否相等，如果相等，则`i++`，`j++`，否则
`i++`，直到`i`或者`j`其中一者到达尾部

当循环结束时，如果`j`到达`dic`的尾部，说明`dic`是`s`的子序列

## 455. [分发饼干](https://leetcode.cn/problems/assign-cookies/)

Code: [455. 分发饼干](./leetcode/editor/cn/Q455_AssignCookies.java)

这题使用贪心算法，需要保证：

1. 给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来给满足度比较大的孩子
2. 满足度最小的孩子最容易得到满足，所以先满足满足度最小的孩子

所以先对`g`和`s`进行排序，然后使用两个指针`si`和`gi`分别指向`g`和`s`的头部，然后循环比较`si`和`gi`指向的值，如果
`s[si] >= g[gi]`，则`si++`，`gi++`，否则`si++`，直到`si`或者`gi`其中一者到达尾部，此时`gi`的值就是满足的孩子数

### 如何保证这是最优解？

我们假设能得到全局最优解，并使用反证法进行证明，即假设存在一种比我们使用的贪心策略更优的最优策略。如果不存在这种最优策略，表示贪心策略就是最优策略，得到的解也就是全局最优解

证明：假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，第 m 个饼干为可以满足该孩子的最小饼干。假设存在一种最优策略，可以给该孩子分配第
n 个饼干，并且 m < n。我们可以发现，经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比最优策略来得大。因此在后续的分配中，贪心策略一定能满足更多的孩子。也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略

## 435. [无重叠区间](https://leetcode.cn/problems/non-overlapping-intervals/)

Code: [435. 无重叠区间](./leetcode/editor/cn/Q435_NonOverlappingIntervals.java)

本题的题意可以表达为:今天有好几个活动，每个活动都可以用区间`[start,end]`表示开始和结束的时间，那么最多能参加几个活动？

所以优先选择参加那些结束时间早的，因为这样可以留下更多的时间参加其余的活动。如果有多个结束时间相同的，选择开始时间晚的，因为这样有助于参加更多的活动

所以总体思路就是先把`intervals`先做个优先级排序，排在前面的优先级高于排在后面的。规则为：

1. 按照结束时间从早到晚排序，结束时间相同的，开始时间晚的排在前面
2. 遍历排序好的`intervals`，如果后面的活动和前面的活动冲突了，就选择移除后面的活动

对于算法，首先使用`Arrays.sort`对`intervals`进行排序，其中使用java的lambda表达式来定义排序规则，让比对的对象为`intervals`
中的每个小数组的第二位，即结束时间。所以在排序后将会得到一个按照结束时间从早到晚排序的`intervals`

然后定义`end`为`intervals[0][1]`，遍历`intervals`，即第一个活动的结束时间，定义`available`为1，即第一个活动一定是要参加的，然后从第二个活动开始遍历，如果
`intervals[i][0] >= end`，说明这个活动和前一个活动不冲突，可以参加，`end`更新为`intervals[i][1]`，`available++`
，否则直接跳过。因为最后需要返回的是最多能参加的活动数，所以最后返回`intervals.length - available`即可

### Lambda表达式的速度优化

Lambda表达式的速度比较慢，可以使用`Comparator`接口来实现排序，速度会更快

```java
public int eraseOverlapIntervals(int[][] intervals) {
    // ...
    Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
        }
    });
}
```

## 452. [用最少数量的箭引爆气球](https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/)

Code: [452. 用最少数量的箭引爆气球](./leetcode/editor/cn/Q452_MinimumNumberOfArrowsToBurstBalloons.java)

和上一题类似，本题的题意可以表达为:今天有好几个气球，每个气球都可以用区间`[start,end]`表示开始和结束的位置，那么最少需要多少箭可以引爆所有的气球？

所以只需注意类似`[1, 2]`和`[2, 3]`是重叠的，所以只需要一支箭就可以引爆这两个气球

## 406. [根据身高重建队列](https://leetcode.cn/problems/queue-reconstruction-by-height/)

Code: [406. 根据身高重建队列](./leetcode/editor/cn/Q406_QueueReconstructionByHeight.java)

本题的题意可以表达为:有随机打乱的好多人，每个人都有`h`表示身高、`k`表示在这个人前面至少有`k`个人的身高大于等于`h`，如何确定每个人站在哪里？

由于第二个属性显示的是比这个人高的人的数量，所以可以先按照身高从高到低排序，然后按照第二个属性从小到大排序

所以在排序时首先判断`h`是否相等，如果相等则按照`k`从小到大排序，否则按照`h`从大到小排序

然后遍历排序好的数组，根据`k`的值插入到对应的位置即可。直接按序插入即可，因为前面的人都比较高，所以就算直接插入也不会影响前面的人

具象化表示：

```
[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]
```

排序后：

```
[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]
```

遍历（按照`k`的值插入）：

```
[7, 0]
[7, 0], [7, 1]
[7, 0], [6, 1], [7, 1]
[5, 0], [7, 0], [6, 1], [7, 1]
[5, 0], [7, 0], [5, 2], [6, 1], [7, 1]
[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]
```

## 121. [买卖股票的最佳时机](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)

Code: [121. 买卖股票的最佳时机](./leetcode/editor/cn/Q121_BestTimeToBuyAndSellStock.java)

只需要记住最低点，然后计算当前点和最低点的差值，取最大值

## 122. [买卖股票的最佳时机 II](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/)

Code: [122. 买卖股票的最佳时机 II](./leetcode/editor/cn/Q122_BestTimeToBuyAndSellStockIi.java)

因为一次只能持有一只股票，所以只要今天的价格比昨天的价格高就卖出，然后累加就是最大的利润

## 605. [种花问题](https://leetcode.cn/problems/can-place-flowers/)

Code: [605. 种花问题](./leetcode/editor/cn/Q605_CanPlaceFlowers.java)

虽然官方题解是贪心算法，但是我直接使用了遍历的方式，每次判断当前位置是否可以种花，如果可以种花则`n--`，跳过下一个位置因为已经种花了。

对于首尾的情况，只需要判断`flowerbed[1]`和`flowerbed[n - 2]`是否为0

## 392. [判断子序列](https://leetcode.cn/problems/is-subsequence/)

Code: [392. 判断子序列](./leetcode/editor/cn/Q392_IsSubsequence.java)

使用String的`indexOf`方法来判断是否是子序列。定义`index`为-1，循环判断`s`中的每个字符在`t`中的位置，如果找到了，则更新`index`为当前字符在`t`中的位置，否则返回false

`indexOf`接受输入的参数为`(char c, int fromIndex)`，表示从`fromIndex`开始查找字符`c`在`t`中的位置，所以每次查找时都要将`fromIndex`更新为当前字符在`t`中的位置加1

## 665. [非递减数列](https://leetcode.cn/problems/non-decreasing-array/)

Code: [665. 非递减数列](./leetcode/editor/cn/Q665_NonDecreasingArray.java)

当出现`nums[i] < nums[i - 1]`时，需要考虑应该修改`nums[i]`还是`nums[i - 1]`才能让`i`之前的数列成为非递减数组，并且不影响后续的操作

优先考虑修改`nums[i - 1] = nums[i]`，因为这样不会让`nums[i]`这个数变大，避免导致`nums[i] > nums[i + 1]`

还有个特殊情况，就是`nums[i] < nums[i - 2]`，此时只能修改`nums[i] = nums[i - 1]`

## 53. [最大子数组和](https://leetcode.cn/problems/maximum-subarray/)

Code: [53. 最大子数组和](./leetcode/editor/cn/Q53_MaximumSubarray.java)

使用贪心的思路，定义`preSum`为`nums[0]`，进入循环。

每次都给`preSum`加上当前的值`nums[i]`，如果`preSum > maxSum`，则更新`maxSum`为`preSum`

当遇到`preSum < 0`时，将`preSum`置为`nums[i]`，然后继续循环，相当于舍弃了前面的部分。但是由于前段的最大值已记录在`maxSum`中，所以不会丢失最大值

## 763. [划分字母区间](https://leetcode.cn/problems/partition-labels/)

Code: [763. 划分字母区间](./leetcode/editor/cn/Q763_PartitionLabels.java)

使用贪心的思路，定义`last`为每个字母在`s`中最后出现的位置，然后遍历`s`，当`i`等于`last`时，说明当前的字母区间已经划分完毕，更新`last`为当前字母的最后位置，然后将当前的字母区间加入结果中

举例：假设`s = "ababcbacadefegdehijhklij"`，那么`last`的值为：

| a | b | c | d | e | f | g | h  | i  | j |
|---|---|---|---|---|---|---|----|----|---|
| 8 | 5 | 2 | 4 | 7 | 6 | 3 | 15 | 14 | 9 |

所以当遍历到`i = 8`时，说明当前的字母区间已经划分完毕，更新`last`为`8`，然后将当前的字母区间加入结果中