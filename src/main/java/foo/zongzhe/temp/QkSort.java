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
        int middle = (start + end)/2;
        int middleValue = nums[middle];
        int leftIndex = start;
        int rightIndex = end;
        while(leftIndex<rightIndex){
            while(nums[leftIndex]<middleValue && leftIndex<rightIndex) leftIndex++;
            while(nums[rightIndex]<middleValue && leftIndex<rightIndex) rightIndex--;
            ArrayUtil.swap(nums, leftIndex, rightIndex);
            if (leftIndex >= rightIndex) break;
            if (leftIndex == middle) rightIndex--;
            if (rightIndex == middle) leftIndex++;
        }

    }
}
