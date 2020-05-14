package foo.zongzhe.algo.sort;

public class ShellSort extends Sort {

    public ShellSort(int[] array) {
        super(array);
        sortDesc = "ShellSort";
    }

    /**
     * 基本思想：
     * 记录基于下标的一定增量的分组，对每个分组使用直接插入排序。
     * 随着增量的逐渐减少，每组包含的关键词越来越多。当增量减到1时，整个文件被分成1组，排序终止
     * 注意：此处的内部排序是移动法排序，快
     */
    @Override
    public void sort() {
        startTime = System.currentTimeMillis();
        for (int step = array.length / 2; step > 0; step = step / 2) {
            // 逐个对其所在的组进行直接插入
            for (int i = step; i < array.length; i++) {
                int j = i;
                int insertValue = array[j];
                while (j - step >= 0 && insertValue < array[j - step]) {
                    array[j] = array[j - step];
                    j -= step;
                }
                array[j] = insertValue;
            }
        }
        endTime = System.currentTimeMillis();
        printResult(endTime - startTime);
    }

    /**
     * 注意：此处的内部排序是交换法排序，慢
     */
    public void sort2() {
        startTime = System.currentTimeMillis();
        for (int step = array.length / 2; step > 0; step = step / 2) {
            for (int i = step; i < array.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if (array[j] > array[j + step]) {
                        swap(j, j + step);
                    }
                }
            }
        }
        endTime = System.currentTimeMillis();
        printResult(endTime - startTime);
    }
}
