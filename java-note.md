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


