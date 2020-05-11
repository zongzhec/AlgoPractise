package foo.zongzhe.algo.recursion.app;

/**
 * 利用递归解决迷宫问题
 */
public class MazePrac {

    public static void main(String[] args) {
        // 先创建一个二维数组模拟迷宫
        int[][] map = new int[8][7];
        // 使用1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 加两个挡板
        map[3][1] = 1;
        map[3][2] = 1;

        // 输出地图
        System.out.println("输出地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        if (setWay(map, 1, 1)) {
            System.out.println("输出通路");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

    /**
     * 使用递归回溯来给小球找路
     * 0 表示该店没有走过
     * 1 表示墙
     * 2 表示已经走过，且能走通
     * 3 表示已经走过，但走不通
     * 策略：下->右->上->左
     *
     * @param map 地图
     * @param i   开始的行
     * @param j   开始的列
     * @return 如果能找到路，就返回true，否则false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 说明通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) { // 当前的点还没有走过
                map[i][j] = 2; // 假定该点可以走通
                if (setWay(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    map[i][j] = 3; // 该点走不通
                    return false;
                }
            } else if (map[i][j] == 1) {
                return false;
            } else if (map[i][j] == 2) {
                return true;
            } else {
                return false;
            }
        }
    }
}
