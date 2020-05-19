package foo.zongzhe.algo.sort;

import foo.zongzhe.utils.ArrayUtil;

import java.util.ArrayList;

/**
 * 基数排序，又称桶子法，属于桶排序的扩展
 */
public class RadixSort extends Sort {

    /**
     * 基本思想：
     * 将所有待比较的数值同一位同样的数位长度，数位较短的前面补0
     * 然后从最低位开始，一次进行一次排序，这样从最低位排序一直到最高位排序完成以后，数列就会变成一个有序序列
     *
     * @param array
     */
    public RadixSort(int[] array) {
        super(array);
        this.array = array;
        sortDesc = "RadixSort";
    }

    @Override
    public void sort(String size) {
        printResult(size, state,endTime - startTime);
        startTime = System.currentTimeMillis();
        boolean hasHigherNum = true; // 标记是否还有更高的数位
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        // 初始化桶
        for (int i = 0; i <= 9; i++) {
            buckets.add(new ArrayList<>());
        }

        int radix = 1;
        while (hasHigherNum) {
            radix *= 10;
            hasHigherNum = false;

            // 初始化桶
            for (ArrayList<Integer> bucket : buckets) {
                bucket.clear();
            }
            for (int num : array) {
                int pos = (num % radix) / (radix / 10);
                if (pos > 0) {
                    hasHigherNum = true;
                }
                buckets.get(pos).add(num);
            }

            // 把数据加回去
            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (int num : bucket) {
                    array[index] = num;
                    index++;
                }
            }
        }
        endTime = System.currentTimeMillis();
        state = Constant.AFTER;
        printResult(size, state,endTime - startTime);
    }
}
