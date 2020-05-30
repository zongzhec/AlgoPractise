package foo.zongzhe.algo.search;

public class InsertSearch extends Search {

    public InsertSearch(int[] array) {
        super(array);
        searchDesc = "InsertSearch";
    }

    @Override
    public int search(int target) {
        searchRound = 0; // initial round for each search
        startTime = System.currentTimeMillis();
        return insertSearch(0, array.length - 1, target);
    }

    private int insertSearch(int start, int end, int target) {
        searchRound++;
        if (start > end || target < array[start] || target > array[end]) {
            endTime = System.currentTimeMillis();
            return -1;
        }
        int middle = start + (end - start) * (target - array[start]) / (array[end] - array[start]); // 核心
        if (target == array[middle]) {
            endTime = System.currentTimeMillis();
            return middle;
        } else if (target < array[middle]) {
            return insertSearch(start, middle - 1, target);
        } else {
            return insertSearch(middle + 1, end, target);
        }
    }
}
