package foo.zongzhe.algo.sort;

public class BubbleSort extends Sort {
    private int[] array;

    public BubbleSort(int[] array) {
        super(array);
        this.array = array;
        sortDesc = "BubbleSort";
    }

    /**
     * 冒泡排序（含优化算法）
     * 定义swapHappened标识是否进行过交换，如果一次for循环内没有进行过交换，则数列已经有序
     */
    @Override
    public void sort(String size) {
        printResult(size, state,endTime - startTime);
        startTime = System.currentTimeMillis();
        boolean swapHappened = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                    swapHappened = true;
                }
            }
            if (!swapHappened) {
                // 在一趟排序中，一次交换都没有发生
                break;
            } else {
                swapHappened = false;
            }
        }
        endTime = System.currentTimeMillis();
        state = Constant.AFTER;
        printResult(size, state,endTime - startTime);
    }
}
