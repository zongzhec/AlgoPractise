package foo.zongzhe.algo.sort;

/**
 * 使用不同的方法进行排序
 */
public class SortDemo {

    public static int[] smallArray;
    public static int[] hugeArray;
    public static String smallSize = Constant.SMALL;
    public static String largeSize = Constant.LARGE;

    public static void main(String[] args) {
        smallArray = getSmallArray();
        BubbleSort bubbleSort = new BubbleSort(smallArray);
        bubbleSort.sort(smallSize);
        hugeArray = getHugeArray();
        bubbleSort = new BubbleSort(hugeArray);
//        bubbleSort.sort(largeSize); // 超过10万数据的时候就难以等待了

        smallArray = getSmallArray();
        SelectSort selectionSort = new SelectSort(smallArray);
        selectionSort.sort(smallSize);
        hugeArray = getHugeArray();
        selectionSort = new SelectSort(hugeArray);
//        selectionSort.sort(largeSize); // 超过10万数据的时候就难以等待了

        smallArray = getSmallArray();
        InsertSort insertSort = new InsertSort(smallArray);
        insertSort.sort(smallSize);
        hugeArray = getHugeArray();
        insertSort = new InsertSort(hugeArray);
//        insertSort.sort(largeSize); // 超过10万数据的时候就难以等待了

        smallArray = getSmallArray();
        ShellSort shellSort = new ShellSort(smallArray);
        shellSort.sort(smallSize);
        hugeArray = getHugeArray();
        shellSort = new ShellSort(hugeArray);
        shellSort.sort(largeSize);

        smallArray = getSmallArray();
        QuickSort quickSort = new QuickSort(smallArray);
        quickSort.sort(smallSize);
        hugeArray = getHugeArray();
        quickSort = new QuickSort(hugeArray);
        quickSort.sort(largeSize);

        smallArray = getSmallArray();
        MergeSort mergeSort = new MergeSort(smallArray);
        mergeSort.sort(smallSize);
        hugeArray = getHugeArray();
        mergeSort = new MergeSort(hugeArray);
        mergeSort.sort(largeSize);

        smallArray = getSmallArray();
        RadixSort radixSort = new RadixSort(smallArray);
        radixSort.sort(smallSize);
        hugeArray = getHugeArray();
        radixSort = new RadixSort(hugeArray);
        radixSort.sort(largeSize);
    }

    public static int[] getSmallArray() {
        int[] array = {53, 3, 542, 91, 748, 14, 214, 2};
        return array;
    }

    public static int[] getHugeArray() {
        int size = 8000000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }
}
