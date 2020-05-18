package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class InsSort {
    int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6};

    public static void main(String[] args) {
        InsSort sort = new InsSort();
        sort.InsSort();
        ArrayUtil.printArray(sort.nums);
    }

    public void InsSort() {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                ArrayUtil.swap(nums, j, j - 1);
                j--;
            }
        }
    }
}
