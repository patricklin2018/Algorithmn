## 04 - 替换空格

### 题目描述

请实现一个函数，将一个字符串中的每个空格替换成`%20`。例如，当字符串为`We Are Happy`.则经过替换之后的字符串为`We%20Are%20Happy`。

### 思路

重新创建一个字符串，遍历原字符串，若不为空格则复制插入新字符串，否则新字符串插入`%20`。

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {

    public String replaceSpace(StringBuffer str) {

        if (str == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        int sz = str.length();
        for (int i = 0; i < sz; ++i) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {
                sb.append("%20");
            }
            else {
                sb.append(str.charAt(i));
            }
        }

        return String.valueOf(sb);
    }

}
```