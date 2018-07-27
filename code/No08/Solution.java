package No08;

/**
 * @Author: patrick-mac
 * @Date: 2018/7/27 21:30
 * @Description:
 *
 * 剑指 Offer - 08 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) throws Exception {
        if (array == null) {
            throw new Exception("数组为空");
        }

        int left = 0, right = array.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (array[mid] >= array[right]) {
                // 左边有序
                left = mid;
            }
            else {
                // 右边有序
                right = mid;
            }
        }

        return array[left] <= array[right] ? array[left] : array[right];
    }
}
