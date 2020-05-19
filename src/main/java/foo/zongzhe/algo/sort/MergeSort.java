package foo.zongzhe.algo.sort;

public class MergeSort extends Sort {

    public MergeSort(int[] array) {
        super(array);
        sortDesc = "MergeSort";
    }

    /**
     * 基本思想：分治策略
     * 先分组，再内部排序，最后合并
     */
    @Override
    public void sort(String size) {
        printResult(size, state,endTime - startTime);
        startTime = System.currentTimeMillis();
        mergeSort(0, array.length - 1);
        endTime = System.currentTimeMillis();
        state = Constant.AFTER;
        printResult(size, state,endTime - startTime);
    }

    /**
     * @param start
     * @param end
     */
    public void mergeSort(int start, int end) {
        // 分解
        int middle = (start + end) / 2;
        if (start < end) {
            mergeSort(start, middle);
            mergeSort(middle + 1, end);
        }
        int[] temp = new int[end - start + 1]; // 中转数组
        int i = start;
        int j = middle + 1;
        int t = 0; // 指向temp数组的下标
        while (i <= middle && j <= end) {
            if (array[i] < array[j]) {
                temp[t] = array[i];
                i++;
            } else {
                temp[t] = array[j];
                j++;
            }
            t++;
        }

        // 一方已经遍历完的时候，要将有剩余元素的另一边一次全部填充到temp
        while (i <= middle) {
            temp[t] = array[i];
            t++;
            i++;
        }

        while (j <= end) {
            temp[t] = array[j];
            t++;
            j++;
        }

        // 将temp数组的元素重新拷贝到原数组
        for (int k = 0; k < temp.length; k++) {
            array[start + k] = temp[k];
        }

    }
}
