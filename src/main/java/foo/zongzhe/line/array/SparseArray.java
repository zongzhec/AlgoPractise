package foo.zongzhe.line.array;

import foo.zongzhe.utils.ArrayUtil;

public class SparseArray {

    /**
     * 将二维数组转化为稀疏数组
     * 1. 记录数组一共有几行几列，有多少个不同的值；
     * 2. 把具有不同值的元素的行列即值记录在一个小规模的数组中，从而缩小程序的规模
     * Sample Input:
     * 0	0	0	22	0	0	15
     * 0	11	0	0	0	17	0
     * 0	0	0	-6	0	0	0
     * 0	0	0	0	0	39	0
     * 91	0	0	0	0	0	0
     * 0	0	28	0	0	0	0
     * <p>
     * Expected Output:
     * 6	7	8
     * 0	3	22
     * 0	6	15
     * 1	1	11
     * 1	5	17
     * 2	3	-6
     * 3	5	39
     * 4	0	91
     * 5	2	28
     */
    public static int[][] twoDimenArrayToSparseArray(int[][] twoDimenArray) {
        int rows = twoDimenArray.length;
        int cols = twoDimenArray[0].length;

        // 遍历数组，记录值的个数，从而初始化稀疏数组
        int valueCount = 0;
        for (int[] ints : twoDimenArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    valueCount++;
                }
            }
        }
        int[][] sparseArray = new int[valueCount + 1][3];

        // 再次遍历数组，记录每一个值
        sparseArray[0][0] = rows;
        sparseArray[0][1] = cols;
        sparseArray[0][2] = valueCount;
        int curRow = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (twoDimenArray[i][j] != 0) {
                    sparseArray[curRow][0] = i;
                    sparseArray[curRow][1] = j;
                    sparseArray[curRow][2] = twoDimenArray[i][j];
                    curRow++;
                }
            }
        }

//        ArrayUtil.printArray(sparseArray);
        return sparseArray;
    }

    /**
     * 将稀疏数组转化为二维数组
     * <p>
     * Sample Input:
     * 6	7	8
     * 0	3	22
     * 0	6	15
     * 1	1	11
     * 1	5	17
     * 2	3	-6
     * 3	5	39
     * 4	0	91
     * 5	2	28
     * <p>
     * Expected Output:
     * 0	0	0	22	0	0	15
     * 0	11	0	0	0	17	0
     * 0	0	0	-6	0	0	0
     * 0	0	0	0	0	39	0
     * 91	0	0	0	0	0	0
     * 0	0	28	0	0	0	0
     */
    public static int[][] sparseArrayToTwoDimenArray(int[][] sparseArray) {
        int rows = sparseArray[0][0];
        int cols = sparseArray[0][1];
        int[][] twoDimenArray = new int[rows][cols];

        // initialize two-dimensional array with default value
        twoDimenArray = ArrayUtil.initArray(twoDimenArray, 0);

        for (int i = 1; i < sparseArray.length; i++) {
            twoDimenArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
//        ArrayUtil.printArray(twoDimenArray);
        return twoDimenArray;
    }
}
