package foo.zongzhe.algo.recursion;

/**
 * 利用递归解决一些问题
 */
public class RecursionDemo {

    public static void main(String[] args) {
        // 1. 打印问题
        solvePrintProblem(5);
        // 2. 阶乘问题
        int res = solveFactorialProblem(5);
        System.out.println("res = " + res);
    }

    /**
     * 给定一个数，返回次数的阶乘
     *
     * @param i
     */
    private static int solveFactorialProblem(int i) {
        if (i == 1) {
            return i;
        } else {
            return i * solveFactorialProblem(i - 1);
        }
    }

    /**
     * 给定一个数，从它开始一直打印到1。
     */
    private static void solvePrintProblem(int maxValue) {
        if (maxValue <= 1) {
            System.out.println("n=" + maxValue);
        } else {
            System.out.println("n=" + maxValue);
            solvePrintProblem(maxValue - 1);
        }
    }
}
