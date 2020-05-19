package foo.zongzhe.algo.sort;

public class InsertSort extends Sort {

    public InsertSort(int[] array) {
        super(array);
        sortDesc = "InsertSort";
    }

    /**
     * 基本思想：
     * 把n个待排序的元素看称为一个有序表和一个无序表。
     * 开始时有序表只包含一个元素，无序表中包含n-1个元素
     * 排序过程中每次从无序表中取出第一个元素，把它的排序码一次与有序表元素的排序码进行比较，并插入到适当的位置，使之称为新的有序表。
     */
    @Override
    public void sort(String size) {
        printResult(size, state,endTime - startTime);
        startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int insertIndex = i - 1;
            int insertValue = array[i];
            while (insertIndex >= 0 && array[insertIndex] > insertValue) {
                array[insertIndex + 1] = array[insertIndex]; // 后移一位
                insertIndex--;
            }
                array[insertIndex + 1] = insertValue;
        }
        endTime = System.currentTimeMillis();
        state = Constant.AFTER;
        printResult(size, state,endTime - startTime);
    }
}
