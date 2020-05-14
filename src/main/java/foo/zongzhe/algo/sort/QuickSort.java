package foo.zongzhe.algo.sort;

public class QuickSort extends Sort {

    public QuickSort(int[] array) {
        super(array);
        sortDesc = "QuickSort";
    }

    /**
     * 基本思想：
     * 通过一趟排序，将所有要排序的数据分成独立的两个部分，其中一部分的数据都比另外一部分所有数据要小。
     * 然后再按此方法对这两部分数据分别进行快速排序，整个过程可以递归进行。
     */
    @Override
    public void sort() {
        startTime = System.currentTimeMillis();
        quickSort(0, array.length - 1);
        endTime = System.currentTimeMillis();
        printResult(endTime - startTime);
    }

    public void quickSort(int start, int end) {
        if (start >= end) {
            return;
        } else {
            int left = start;
            int right = end;
//            int middle = (start + end) / 2; // 不要有中值下标，因为中值会移动
            int middleValue = array[(start + end) / 2]; // 也可以写作pivot，中轴值
            while (left < right) {
                while (array[right] > middleValue) right--;
                while (array[left] < middleValue) left++;
                swap(left, right);
                if (left >= right) break; // 感觉可以不用判断大于，有待考证
                if (array[right] == middleValue) left++; // 左边走到头了
                if (array[left] == middleValue) right--;
            }
            quickSort(start, left-1);
            quickSort(right+1, end);
        }
    }
}
