# Java笔记

## String

### substring

`str.substring(3)`截取除前三位以外的后面部分

`str.substring(2, 7)`截取index==2到index==6的部分

#### Note

substring编号从0开始，每个编号的意义是第x位字符的内存起始点，所以

```
String str = "abcde";
str.substring(1, 3);
```

的结果为`bc`

### compareTo

定义字符串`str1`和`str2`，`str1.compareTo(str2)`：
1. 返回两个字符串的asc码差值，从头开始一一比较，返回第一个不同字母的asc码差值
    ``` java
    String str1 = "aa";
    String str2 = "ad";
    System.out.println(str1.compareTo(str2)); // -3
    ```
2. 如果两个字符串长度不同，返回两个字符串长度差值
    ``` java
    String str1 = "aa";
    String str2 = "a";
    System.out.println(str1.compareTo(str2)); // 1
    ```
3. 返回正数，说明`str1 > str2`，返回负数，说明`str1 < str2`，返回0，说明`str1 = str2`
4. `compareToIgnoreCase`忽略大小写
5. `int`类型之间不能使用`compareTo`方法，需要转换为`String`类型。但是两个`Integer`类型可以

### 桶

1.1、概念
计数排序：的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

1.2、算法步骤
找出待排序的数组中的最大元素max和最小元素min
根据指定的桶数创建桶，本文使用的桶是List结构，桶里面的数据也采用List结构存储
根据公式遍历数组元素：桶编号 = (数组元素 - 最小值) * (桶个数 - 1) / (最大值 - 最小值)，把数据放到相应的桶中
从小到大遍历每一个桶，同时对桶里的元素进行排序
把排好序的元素从索引为0开始放入（因为前一个桶的数据一定小于后一个桶的数据，然后每个桶里的数据又是有序的），完成排序