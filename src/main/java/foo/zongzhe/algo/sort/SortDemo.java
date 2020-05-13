package foo.zongzhe.algo.sort;

/**
 * 使用不同的方法进行排序
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] array = getNewArray();
        BubbleSort bubbleSort = new BubbleSort(array);
        bubbleSort.printArray();
        bubbleSort.sort();
        bubbleSort.printArray();

        array = getNewArray();
        BubbleSort bubbleSort2 = new BubbleSort(array);
        bubbleSort2.printArray();
        bubbleSort2.sort();
        bubbleSort2.printArray();
    }

    public static int[] getNewArray() {
        int[] array = {3, 9, -1, 20, 10};
        return array;
    }
}
