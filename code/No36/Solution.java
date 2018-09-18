package No36;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 20:35
 * @Description:
 */
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
