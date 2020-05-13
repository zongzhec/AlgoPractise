package foo.zongzhe.algo.sort;

public class SelectionSort extends Sort {

    public SelectionSort(int[] array) {
        super(array);
        sortDesc = "SelectionSort";
    }

    /**
     * 基本思想：
     * 每次都选取最小值，然后跟待排序数列的最前面交换。
     */
    @Override
    public void sort() {
        printArray(false);
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
        printArray(true);
    }


}
