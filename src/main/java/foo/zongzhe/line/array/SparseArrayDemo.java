package foo.zongzhe.line.array;

import foo.zongzhe.utils.ArrayUtil;
import foo.zongzhe.utils.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static foo.zongzhe.utils.Constants.PIPE;
import static foo.zongzhe.utils.Constants.TAB;

/**
 * 稀疏数组
 */
public class SparseArrayDemo {

    public static void main(String[] args) {
        int[][] twoDimonArray = initializeTwoDimonArray();
    }

    private static int[][] initializeTwoDimonArray() {

        // 首先尝试读取文件
        ArrayList<String> arrayFileContent = FileUtil.readFile("src/main/resources/foo/zongzhe/line/array/TwoDimonArrayInput.txt");
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
        int[][] twoDimonArray = new int[rows][cols];

        // 解析成数组
        int currentRow = 0;
        int currentCol = 0;
        for (String line : arrayFileContent) {
            String[] strs = line.split(PIPE);
            for (String str : strs) {
                twoDimonArray[currentRow][currentCol] = Integer.parseInt(str);
                currentCol++;
            }
            currentCol = 0;
            currentRow++;
        }

        // 输出数组信息
        ArrayUtil.printArray(twoDimonArray);

        return twoDimonArray;
    }


}
