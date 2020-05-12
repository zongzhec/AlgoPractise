package foo.zongzhe.algo.recursion.app;

/**
 * 使用递归解决8皇后问题
 * 理论上应该创建一个二维数组，但是实际上可以通过算法，用一个一位数组即可解决问题
 */
public class EightQueenPrac {
    int queenNum = 8;
    int[] queenLoc = new int[queenNum]; // 保存皇后放置结果，下标表示第几行，数值代表第几列

    public static void main(String[] args) {
        EightQueenPrac eightQueen = new EightQueenPrac();
        eightQueen.placeQueen(0);
    }

    private void placeQueen(int n) {
        if (n == queenNum) { // 所有皇后已经放好了
            showLoc(queenLoc);
            return;
        }
        // 一次放入皇后，并判断是否冲突
        for (int i = 0; i < queenNum; i++) {
            // 先把当前皇后放到改行的第一列
            queenLoc[n] = i;
            if (judge(n)) { // 不冲突
                // 接着放n+1
                placeQueen(n + 1);
            }
        }
    }

    /**
     * 查看当我们放置第n个皇后时，是否和前面已经摆放的皇后冲突
     *
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (queenLoc[i] == queenLoc[n] || Math.abs(n - i) == Math.abs(queenLoc[n] - queenLoc[i])) { // 同一列或者一个斜线
                return false;
            }
        }
        return true;
    }

    private static void showLoc(int[] locations) {
        for (int i = 0; i < locations.length; i++) {
            System.out.print(locations[i] + " ");
        }
        System.out.println();
    }

}
