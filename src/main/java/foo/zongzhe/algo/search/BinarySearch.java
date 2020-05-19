package foo.zongzhe.algo.search;

public class BinarySearch {
    int[] array = {91, 542, 2, 53, 3, 14, 214, 748};

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(53);
        System.out.println("index = " + index);
    }

    /**
     * 要求数组必须有序
     * @param target
     * @return
     */
    public int search(int target) {
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
