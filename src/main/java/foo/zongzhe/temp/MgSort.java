package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class MgSort {
    int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6};

    public static void main(String[] args) {
        MgSort sort = new MgSort();
        sort.mSort(0, sort.nums.length - 1);
        ArrayUtil.printArray(sort.nums);
    }

    public void mSort(int start, int end) {
        int middle = (start + end) / 2;
        if (start != end) {
            mSort(start, middle);
            mSort(middle + 1, end);
        }
        int[] temp = new int[end - start + 1];
        int leftIndex = start;
        int rightIndex = middle + 1;
        int tempIndex = 0;
        while (leftIndex <= middle && rightIndex <= end) {
            if (nums[leftIndex] < nums[rightIndex]) {
                temp[tempIndex] = nums[leftIndex];
                leftIndex++;
            } else {
                temp[tempIndex] = nums[rightIndex];
                rightIndex++;
            }
            tempIndex++;
        }
        while (leftIndex <= middle) {
            temp[tempIndex] = nums[leftIndex];
            leftIndex++;
            tempIndex++;
        }
        while (rightIndex <= end) {
            temp[tempIndex] = nums[rightIndex];
            rightIndex++;
            tempIndex++;
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, nums, start + 0, temp.length);
    }
}
