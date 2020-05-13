package foo.zongzhe.algo.sort;

public class Sort {
    public int[] array;
    public String sortDesc = "Sort";

    public Sort(int[] array) {
        this.array = array;
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray() {
        System.out.print("Sorted by " + sortDesc + ": ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
