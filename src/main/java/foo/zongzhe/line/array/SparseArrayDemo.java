package foo.zongzhe.line.array;

import foo.zongzhe.utils.ArrayUtil;
import foo.zongzhe.utils.FileUtil;
import java.util.ArrayList;
import static foo.zongzhe.utils.Constants.PIPE;

/**
 * 稀疏数组
 */
public class SparseArrayDemo {

    public static void main(String[] args) {

        // 初始化一个二维数组
        int[][] twoDimenArray = initializeTwoDimenArray();
        ArrayUtil.printArraySize(twoDimenArray, "twoDimenArray");

        // 转换成稀疏数组
        int[][] sparseArray = SparseArray.twoDimenArrayToSparseArray(twoDimenArray);
        ArrayUtil.printArraySize(sparseArray, "sparseArray");

        // 还原成二维数组
        int[][] revertedTwoDimenArray =SparseArray.sparseArrayToTwoDimenArray(sparseArray);
    }

    private static int[][] initializeTwoDimenArray() {

        // 首先尝试读取文件
        ArrayList<String> arrayFileContent = FileUtil.readFile("src/main/resources/foo/zongzhe/line/array/TwoDimenArrayFile.txt");
        if (arrayFileContent == null || arrayFileContent.isEmpty()) {
            // 文件无法读取或者为空，则手动生成
            arrayFileContent.add("0|0|0|22|0|0|15");
            arrayFileContent.add("0|11|0|0|0|17|0");
            arrayFileContent.add("0|0|0|-6|0|0|0");
            arrayFileContent.add("0|0|0|0|0|39|0");
            arrayFileContent.add("91|0|0|0|0|0|0");
            arrayFileContent.add("0|0|28|0|0|0|0");
        }

        // 初始化数组信息
        int rows = arrayFileContent.size();
        int cols = arrayFileContent.get(0).split(PIPE).length;
        System.out.println(String.format("Array from input contains %d rows and %d columns", rows, cols));
        int[][] twoDimenArray = new int[rows][cols];

        // 解析成数组
        int currentRow = 0;
        int currentCol = 0;
        for (String line : arrayFileContent) {
            String[] strs = line.split(PIPE);
            for (String str : strs) {
                twoDimenArray[currentRow][currentCol] = Integer.parseInt(str);
                currentCol++;
            }
            currentCol = 0;
            currentRow++;
        }

        // 输出数组信息
//        ArrayUtil.printArray(twoDimenArray);

        return twoDimenArray;
    }


}
