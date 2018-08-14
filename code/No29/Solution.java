package No29;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: patrick-mac
 * @Date: 2018/8/14 15:30
 * @Description:
 *
 * 剑指 offer - 29 字符串的排列
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
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

    public static void main(String[] args) {
        new Solution().Permutation("aa");
    }
}
