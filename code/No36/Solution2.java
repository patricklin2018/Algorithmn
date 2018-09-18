package No36;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 20:47
 * @Description:
 */
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
