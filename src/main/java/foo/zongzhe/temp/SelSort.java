package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class SelSort {
    int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6};

    public static void main(String[] args) {
        SelSort sSoret = new SelSort();
        sSoret.selSort();
        ArrayUtil.printArray(sSoret.nums);
    }

    public void selSort() {
        for (int step = nums.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                int j = i;
                int insertValue = nums[j];
                while (j - step >= 0 && nums[j - step] > nums[j]) {
                    nums[j] = nums[j - step];
                    j -= step;
                }
                nums[j] = insertValue;
            }
        }
    }
}
