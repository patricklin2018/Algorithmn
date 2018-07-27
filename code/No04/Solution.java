package No04;

/**
 * @author PatrickLin
 * @date 2018/7/24 22:27
 * @description
 *
 * 剑指 offer - 04 替换空格
 *
 * 题目描述：
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 **/
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
