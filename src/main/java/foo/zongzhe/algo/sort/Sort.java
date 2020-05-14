package foo.zongzhe.algo.sort;

import foo.zongzhe.utils.ArrayUtil;

public abstract class Sort {
    public int[] array;
    public String sortDesc = "Sort";
    public long startTime;
    public long endTime;
    public long runTime;

    public Sort(int[] array) {
        this.array = array;
    }

    public abstract void sort();

    public void swap(int i, int j) {
        ArrayUtil.swap(array, i, j);
    }

    public void printResult(long runtime) {
        System.out.print("Sorted by " + sortDesc + ": ");
        ArrayUtil.printArray(array);
        System.out.println("Run time: " + runtime);
    }
}
