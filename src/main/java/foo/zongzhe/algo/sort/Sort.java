package foo.zongzhe.algo.sort;

import foo.zongzhe.utils.ArrayUtil;

public abstract class Sort {
    public int[] array;
    public String sortDesc = "Sort";
    public long startTime;
    public long endTime;
    public long runTime;
    public String state;

    public Sort(int[] array) {
        this.array = array;
        state = Constant.BEFORE;
        startTime = 0;
        endTime = 0;
    }

    public abstract void sort(String size);

    public void swap(int i, int j) {
        ArrayUtil.swap(array, i, j);
    }

    /**
     * 输出数组内容
     * 如果是小数组排序，则输出排序前后的内容
     * 如果是大数组排序，则输出排序所需的时间
     * @param state
     * @param runtime
     */
    public void printResult(String size, String state, long runtime) {
        if (size.equals(Constant.SMALL)){
            System.out.printf("%s %s: ", state, sortDesc);
            ArrayUtil.printArray(array);
        }else if (size.equals(Constant.LARGE) && state.equals(Constant.AFTER)){
            System.out.println("Run time: " + (runtime/1000) + " seconds");
            System.out.println();
        }
    }
}
