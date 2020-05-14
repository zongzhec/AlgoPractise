package foo.zongzhe.algo.sort;

/**
 * 使用不同的方法进行排序
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] array = getNewArray();
        BubbleSort bubbleSort = new BubbleSort(array);
        bubbleSort.sort();

        array = getNewArray();
        SelectSort selectionSort = new SelectSort(array);
        selectionSort.sort();

        array = getNewArray();
        InsertSort insertSort = new InsertSort(array);
        insertSort.sort();

        array = getNewArray();
        ShellSort shellSort  = new ShellSort(array);
        shellSort.sort();
    }

    public static int[] getNewArray() {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        return array;
    }
}
