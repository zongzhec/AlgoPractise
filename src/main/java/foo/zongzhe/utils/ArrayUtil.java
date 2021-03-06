package foo.zongzhe.utils;


public class ArrayUtil {

    public static void printArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[][] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                System.out.print(inputArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Initialize Array with default values
     *
     * @param array        Array to be initialized
     * @param defaultValue default value
     */
    public static int[][] initArray(int[][] array, int defaultValue) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = defaultValue;
            }
        }
        return array;
    }

    /**
     * Calculates "size" of an array, generally it is row * col
     *
     * @param array     Array to be calculate
     * @param arrayDesc Array Description
     */
    public static void printArraySize(int[][] array, String arrayDesc) {
        int row = array.length;
        int col = array[0].length;
        System.out.println(String.format("Size of %s is (%d * %d =) %d ", arrayDesc, row, col, (row * col)));
    }

    /**
     * 交换数组中的元素
     *
     * @param array
     * @param index1
     * @param index2
     */
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
