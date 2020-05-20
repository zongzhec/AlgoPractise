package foo.zongzhe.algo.search;

public class BinarySearch {
    int[] array = {2, 3, 14, 53, 91, 214, 542, 748};

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(749);
        System.out.println("index = " + index);
    }

    /**
     * 要求数组必须有序
     *
     * @param target
     * @return
     */
    public int search(int target) {
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                return i;
            }
        }
        return binarySearch(0, array.length - 1, target);
    }

    private int binarySearch(int start, int end, int target) {
        if (start > end) { //说明递归了整个数组，但是没有找到
            return -1;
        } else {
            int middle = (start + end) / 2;
            if (target == array[middle]) {
                return middle;
            } else if (target < array[middle]) {
                return binarySearch(start, middle - 1, target);
            } else {
                return binarySearch(middle + 1, end, target);
            }
        }
    }

    private int binarySearch2(int start, int end, int target) {
        if (start == end || start == end - 1) {
            if (array[start] == target) {
                return start;
            } else if (array[end] == target) {
                return end;
            } else {
                return -1;
            }
        } else {
            int middle = (start + end) / 2;
            if (target == array[middle]) {
                return middle;
            } else if (target < array[middle]) {
                return binarySearch(start, middle, target);
            } else {
                return binarySearch(middle, end, target);
            }
        }
    }
}
