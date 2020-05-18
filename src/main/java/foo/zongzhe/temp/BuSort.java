package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class BuSort {
    int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6};

    public static void main(String[] args) {
        BuSort sort = new BuSort();
        sort.bSort();
        ArrayUtil.printArray(sort.nums);
    }

    public void bSort() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    ArrayUtil.swap(nums, j, j + 1);
                }
            }
        }
    }
}
