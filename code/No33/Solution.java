package No33;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/18 11:03
 * @Description:
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int counter = 0;
        long i = 1;
        while ((n / i) != 0) {
            int pre = (int) (n / (i * 10));
            int cur = (int) ((n / i) % 10);
            int aft = (int) (n - (n / i) * i);

            // 如果当前位为 0 ， 那么 1 的个数取决于高位，等于高位 * 当前位数
            if (cur == 0) {
                counter += pre * i;
            }
            // 如果当前位为 1， 那么 1 的个数不仅取决于高位，还取决于低位，等于高位 * 当前位数 + 低位 + 1
            else if (cur == 1) {
                counter += pre * i + aft + 1;
            }
            // 如果当前位为 2 - 9， 那么 1 的个数取决于高位，等于（高位 + 1） * 当前位数
            else {
                counter += (pre + 1) * i;
            }

            i *= 10;
        }

        return counter;
    }
}
