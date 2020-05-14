package foo.zongzhe.utils;

public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        selectSort(nums);
        ArrayUtil.printArray(nums);

    }

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            int minIndex = i;
            for (int j = i+1; j<array.length;j++){
                if (array[j]< array[minIndex]){
                    minIndex = j;
                }
            }
            ArrayUtil.swap(array, i, minIndex);
        }
    }
}
