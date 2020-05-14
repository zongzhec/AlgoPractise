package foo.zongzhe.temp;

import foo.zongzhe.utils.ArrayUtil;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        insertSort(nums);
        ArrayUtil.printArray(nums);

    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int insertValue = array[i];
            int j = i - 1;
            while (j >= 0 && insertValue < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertValue;
        }
    }
}
