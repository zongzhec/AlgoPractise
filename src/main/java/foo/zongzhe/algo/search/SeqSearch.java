package foo.zongzhe.algo.search;

/**
 * 顺序查找
 */
public class SeqSearch {

    int[] array = {91, 542, 2, 53, 3, 14, 214, 748};

    public static void main(String[] args) {
        SeqSearch seqSearch = new SeqSearch();
        int index = seqSearch.search(53);
        System.out.println("index = " + index);
    }

    public int search(int target) {
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                return i;
            }
        }
        return -1;
    }
}
