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