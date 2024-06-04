# CS-Notes面试笔记力扣经典题

## 167. [两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)

使用双指针的思路，定义左指针指向0，右指针指向`numbers.length - 1`

当两个指针指向的数之和大于`target`时，右指针向左移动，否则左指针向右移动

## 633. [平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers/)

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