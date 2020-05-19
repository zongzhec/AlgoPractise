package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class SelSort {
    int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6};

    public static void main(String[] args) {
        SelSort sSoret = new SelSort();
        sSoret.selSort();
        ArrayUtil.printArray(sSoret.nums);
    }

    /**
     * 基本思想：
     * 每次都选取最小值，然后跟待排序数列的最前面交换。
     */
    public void selSort() {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            ArrayUtil.swap(nums, i, minIndex);
        }
    }
}
