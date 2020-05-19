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
        if (start < end) {
            mSort(start, middle);
            mSort(middle + 1, end);
        }

        int[] temp = new int[end - start + 1];
        int left = start;
        int right = middle + 1;
        int tempIndex = 0;
        while (left <= middle && right <= end) {
            if (nums[left] < nums[right]) {
                temp[tempIndex] = nums[left];
                left++;
            } else {
                temp[tempIndex] = nums[right];
                right++;
            }
            tempIndex++;
        }

        // Copy rest values
        while (left <= middle) {
            temp[tempIndex] = nums[left];
            left++;
            tempIndex++;
        }
        while (right <= end) {
            temp[tempIndex] = nums[right];
            right++;
            tempIndex++;
        }

        // Copy back the values
        System.arraycopy(temp, 0, nums, start, temp.length);
    }
}
