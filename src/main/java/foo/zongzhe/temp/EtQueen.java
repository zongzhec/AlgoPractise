package foo.zongzhe.temp;

public class EtQueen {

    int maxQueen = 8;
    int[] loc = new int[maxQueen];

    public static void main(String[] args) {
        EtQueen queen = new EtQueen();
        queen.place(0);
    }

    public void place(int n) {
        if (n == maxQueen) {
            print();
            return;
        }
        for (int i = 0; i < maxQueen; i++) {
            loc[n] = i;
            if (canPlace(n)) {
                place(n + 1);
            }
        }
    }


    public boolean canPlace(int n) {
        for (int i = 0; i < n; i++) {
            if (loc[i] == loc[n] || Math.abs(i - n) == Math.abs(loc[i] - loc[n])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i : loc) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
