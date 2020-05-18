package foo.zongzhe.algo.sort;

/**
 * 使用不同的方法进行排序
 */
public class SortDemo {
    

    public static void main(String[] args) {
        int[] array = getSmallArray();
        BubbleSort bubbleSort = new BubbleSort(array);
        bubbleSort.sort();

        array = getSmallArray();
        SelectSort selectionSort = new SelectSort(array);
        selectionSort.sort();

        array = getSmallArray();
        InsertSort insertSort = new InsertSort(array);
        insertSort.sort();

        array = getSmallArray();
        ShellSort shellSort = new ShellSort(array);
        shellSort.sort();

        array = getSmallArray();
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();

        array = getSmallArray();
        MergeSort mergeSort = new MergeSort(array);
        mergeSort.sort();

        array = getSmallArray();
        RadixSort radixSort = new RadixSort(array);
        radixSort.sort();
    }

    public static int[] getSmallArray() {
        int[] array = {53, 3, 542, 91, 748, 14, 214, 2};
        return array;
    }

    public static int[] getHugeArray() {
        int size = 80000000;
        int[] array = new int[size];
        for (int i=0;i<size;i++){

        }
        return array;
    }
}
