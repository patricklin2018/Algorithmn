# 36. 第一个只出现一次的字符

## 问题

在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.

## 思路

思路一：

建立一个 `int[] alphabet = new int['z' + 1];` 大小的字母表，统计各个字母出现的次数。最后查找仅出现一次的字符。

思路二：

采用一个 `Map<Character, Integer> map = new LinkedHashMap<>();` 来记录字符的出现次数，因为 `LinkedHashMap` 内部额外维护了一条双向链表用来记录进入的顺序。

## 实现

[代码 - 思路 1 - Java](Solution.java)

[代码 - 思路 2 - Java](Solution2.java)

### 思路 1 - Java

```java
public class Solution {
    public int FirstNotRepeatingChar(String str) {
         // 字母表
        int[] alphabet = new int['z' + 1];
        int sz = str.length();
        for (int i = 0; i < sz; ++i) {
            alphabet[str.charAt(i)]++;
        }
        for (int i = 0; i < sz; ++i) {
            if (alphabet[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
}
```

### 思路 2 - Java

```java
public class Solution2 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        int sz = str.length();
        for (int i = 0; i < sz; ++i) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 2);
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return str.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
```