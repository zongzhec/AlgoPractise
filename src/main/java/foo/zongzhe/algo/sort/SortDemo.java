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
        SelectionSort selectionSort = new SelectionSort(array);
        selectionSort.sort();
    }

    public static int[] getNewArray() {
        int[] array = {3, 9, -1, 20, 10};
        return array;
    }
}
