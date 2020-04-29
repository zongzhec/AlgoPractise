package foo.zongzhe.utils;

import static foo.zongzhe.utils.Constants.TAB;

public class ArrayUtil {

    public static void printArray(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
