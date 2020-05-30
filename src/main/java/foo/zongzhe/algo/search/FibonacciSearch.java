package foo.zongzhe.algo.search;

import java.util.Arrays;

public class FibonacciSearch extends Search {

    public FibonacciSearch(int[] array) {
        super(array);
        searchDesc = "FibonacciSearch";
    }

    /**
     * 先获取一个斐波那契数列
     *
     * @return
     */
    public int[] getFibonacciArray() {
        int[] fo = new int[array.length];
        fo[0] = 1;
        fo[1] = 1;
        for (int i = 2; i < array.length; i++) {
            fo[i] = fo[i - 1] + fo[i - 2];
        }
        return fo;
    }

    @Override
    public int search(int target) {
        searchRound = 0;
        startTime = System.currentTimeMillis();
        int[] foArray = getFibonacciArray();
        return fibonacciSearchNoRecur(target, foArray);
    }

    /**
     * 使用非递归的方法进行斐波那契查找
     *
     * @param target
     * @return
     */
    private int fibonacciSearchNoRecur(int target, int[] foArray) {
        int start = 0;
        int end = array.length - 1;
        int foIndex = 0; // 存放斐波那契分割数值的下标
        int middle = 0; // 存放middle的值

        // 获取到斐波那契分割数组的下标
        while (end > foArray[foIndex] - 1) {
            foIndex++;
        }
        // 构造一个新的数组，不足的部分用原数组最后的值填充
        int[] temp = Arrays.copyOf(array, foArray[foIndex]);
        for (int i = end + 1; i < temp.length; i++) {
            temp[i] = array[end];
        }

        // 使用while循环处理
        while (start <= end) {
            searchRound++;
            middle = start + foArray[foIndex - 1] - 1;
            if (target == temp[middle]) {
                endTime = System.currentTimeMillis();
                return Math.min(middle, end);
            } else if (target < temp[middle]) {
                end = middle - 1;
                foIndex--;
            } else {
                start = middle + 1;
                foIndex = foIndex - 2;
            }
        }
        endTime = System.currentTimeMillis();
        return -1;

    }


}
