package foo.zongzhe.algo.sort;

public class SelectSort extends Sort {

    public SelectSort(int[] array) {
        super(array);
        sortDesc = "SelectSort";
    }

    /**
     * 基本思想：
     * 每次都选取最小值，然后跟待排序数列的最前面交换。
     */
    @Override
    public void sort(String size) {
        printResult(size, state,endTime - startTime);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { // 简单的优化
                swap(minIndex, i);
            }
        }
        endTime = System.currentTimeMillis();
        state = Constant.AFTER;
        printResult(size, state,endTime - startTime);
    }


}
