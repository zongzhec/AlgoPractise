package foo.zongzhe.temp;

public class EightQueen {
    private static int[] loc = new int[8];

    public static void main(String[] args) {
        EightQueen eq = new EightQueen();
        eq.placeQueen(0);

    }

    public void placeQueen(int n) {
        if (n == 8) {
            print();
        } else {
            for (int i = 0; i < 8; i++) {
                loc[n] = i;
                if (canPlace(n)) {
//                    print();
                    placeQueen(n + 1);
                }
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

    public static void print() {
        for (int i : loc) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
