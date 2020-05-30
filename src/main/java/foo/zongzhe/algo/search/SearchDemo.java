package foo.zongzhe.algo.search;

import java.util.ArrayList;

public class SearchDemo {

    private static int[] array = {2, 3, 14, 53, 91, 214, 542, 748};

    public static ArrayList<Search> searchMethods = new ArrayList<>();

    public static void main(String[] args) {
        initialSearchMethods();

        search(array[0], "first element");
        search(array[array.length-1], "last element");
        search(array[array.length-1], "middle element");
        search(array[array.length-1], "non-existing element");
    }

    private static void initialSearchMethods() {
        searchMethods.add(new BinarySearch(array));
    }

    private static void search(int target, String desc) {
        System.out.printf("Searching for %s: %d\n", desc, target);
        for (Search searchMethod : searchMethods) {
            int index = searchMethod.search(target);
            System.out.printf("Method is %s, index=%d, round=%d, time=%d\n",
                    searchMethod.searchDesc, index, searchMethod.searchRound,
                    (searchMethod.endTime - searchMethod.startTime));
        }

    }
}
