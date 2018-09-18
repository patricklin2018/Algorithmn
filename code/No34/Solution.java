package No34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 15:12
 * @Description:
 */
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int e : numbers) {
            list.add(e);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String ab = o1 + "" + o2;
                String ba = o2 + "" + o1;
                return ab.compareTo(ba);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer e : list) {
            sb.append(e.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        new Solution().PrintMinNumber(nums);
    }
}
