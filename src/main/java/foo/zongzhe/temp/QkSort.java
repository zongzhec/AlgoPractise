package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class QkSort {

    int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6};

    public static void main(String[] args) {
        QkSort sSoret = new QkSort();
        sSoret.qSort(0, sSoret.nums.length - 1);
        ArrayUtil.printArray(sSoret.nums);
    }

    /**
     * 基本思想：
     * 通过一趟排序，将所有要排序的数据分成独立的两个部分，其中一部分的数据都比另外一部分所有数据要小。
     * 然后再按此方法对这两部分数据分别进行快速排序，整个过程可以递归进行。
     */
    public void qSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int middleValue = nums[(start + end) / 2];
        int left = start;
        int right = end;
        while (left < right) {
            while (nums[left] < middleValue) left++;
            while (nums[right] > middleValue) right--;

            ArrayUtil.swap(nums, left, right);
            if (left >= right) break;
            // end of left
            if (nums[left] == middleValue) right++;
            else left++;
        }
        qSort(start, left-1);
        qSort(right + 1, end);
    }
}
