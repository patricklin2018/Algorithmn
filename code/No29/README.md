## 29 - 字符串的排列

### 题目描述

输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串`abc`,则打印出由字符`a`,`b`,`c`所能排列出来的所有字符串`abc`,`acb`,`bac`,`bca`,`cab`和`cba`。

**输入描述:**

输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

### 思路

采用回溯思想，通过递归的方式，按顺序确定第一个字符，第二个，...，直到最后一个字符确定，将该排序加入答案。

![](pic.png)

### 代码
[代码-JAVA](Solution.java)

```java
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();

        if (str == null || str.length() == 0) {
            return res;
        }

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(str);
        Permutation(sb, 0, res);

        // 牛客网的答案验证需要排序
        Collections.sort(res);

        return res;
    }

    public void Permutation(StringBuilder str, int index, ArrayList<String> res) {
        int sz = str.length();
        if (index < sz) {
            for (int i = index; i < sz; ++i) {
                swap(str, index, i);
                Permutation(str, index + 1, res);
                swap(str, index, i);
            }
        }
        else if (index == sz) {
            if (!res.contains(str.toString())) {
                res.add(str.toString());
            }
        }
    }

    public void swap(StringBuilder str, int indexA, int indexB) {
        char A = str.charAt(indexA);
        char B = str.charAt(indexB);

        str.setCharAt(indexA, B);
        str.setCharAt(indexB, A);
    }
}
```