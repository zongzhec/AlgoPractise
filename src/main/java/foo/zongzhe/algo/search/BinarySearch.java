package foo.zongzhe.algo.search;

public class BinarySearch extends Search{
    int[] array = {2, 3, 14, 53, 91, 214, 542, 748};

    public BinarySearch(int[] array) {
        super(array);
        searchDesc = "BinarySearch";
    }

    /**
     * 要求数组必须有序
     *
     * @param target
     * @return
     */
    @Override
    public int search(int target) {
        searchRound = 0; // initial round for each search
      startTime = System.currentTimeMillis();
        return binarySearch(0, array.length - 1, target);
    }

    private int binarySearch(int start, int end, int target) {
        searchRound++;
        if (start > end) { //说明递归了整个数组，但是没有找到
            endTime = System.currentTimeMillis();
            return -1;
        } else {
            int middle = (start + end) / 2;
            if (target == array[middle]) {
                endTime = System.currentTimeMillis();
                return middle;
            } else if (target < array[middle]) {
                return binarySearch(start, middle - 1, target);
            } else {
                return binarySearch(middle + 1, end, target);
            }
        }
    }

}
